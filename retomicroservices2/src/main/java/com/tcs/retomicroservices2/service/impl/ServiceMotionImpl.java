
package com.tcs.retomicroservices2.service.impl;

import com.tcs.retomicroservices2.entity.Account;
import com.tcs.retomicroservices2.entity.Motion;
import com.tcs.retomicroservices2.repository.MotionRepository;
import com.tcs.retomicroservices2.service.ServiceAccount;
import com.tcs.retomicroservices2.service.ServiceMotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceMotionImpl implements ServiceMotion {

    @Autowired
    private MotionRepository motionRepository;

    @Autowired
    private ServiceAccount serviceAccount;

    @Override
    public Motion postMotion(Motion motion) {
        Account account = serviceAccount.getAccountById(motion.getAccountId());

        if (motion.getDatemotion() == null) {
            motion.setDatemotion(LocalDateTime.now());
        }
        Double currentBalance = getCurrentBalance(motion.getAccountId());

        if ("RETIRO".equalsIgnoreCase(motion.getTypemotion())) {
            if (motion.getValue() > currentBalance) {
                throw new RuntimeException("Saldo insuficiente para realizar este retiro");
            }
            motion.setMotionbalance(currentBalance - motion.getValue());
        } else if ("DEPOSITO".equalsIgnoreCase(motion.getTypemotion())) {
            motion.setMotionbalance(currentBalance + motion.getValue());
        } else {
            throw new RuntimeException("Tipo de movimiento no válido. Debe ser DEPOSITO o RETIRO");
        }
        Motion savedMotion = motionRepository.save(motion);

        return populateAccountData(savedMotion);
    }

    @Override
    public List<Motion> getMotions() {
        return motionRepository.findAll().stream()
                .map(this::populateAccountData)
                .collect(Collectors.toList());
    }
    @Override
    public Motion getMotionById(long idMotion) {
        Motion motion = motionRepository.findById(idMotion)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        return populateAccountData(motion);
    }
    @Override
    public void putMotion(long idMotion, Motion updatedMotion) {
        Motion existing = motionRepository.findById(idMotion)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));

        if (updatedMotion.getAccountId() != null && !existing.getAccountId().equals(updatedMotion.getAccountId())) {
            throw new RuntimeException("No se puede cambiar la cuenta asociada a un movimiento");
        }
        if (updatedMotion.getDatemotion() != null) {
            existing.setDatemotion(updatedMotion.getDatemotion());
        }
        if (updatedMotion.getTypemotion() != null) {
            existing.setTypemotion(updatedMotion.getTypemotion());
        }
        if (updatedMotion.getValue() != null) {
            existing.setValue(updatedMotion.getValue());
        }
        recalculateBalances(existing.getAccountId());
        motionRepository.save(existing);
    }

    @Override
    public void deleteMotion(long idMotion) {
        Motion motion = motionRepository.findById(idMotion)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        Long accountId = motion.getAccountId();
        motionRepository.deleteById(idMotion);
        recalculateBalances(accountId);
    }

    @Override
    public List<Motion> getMotionsByAccountId(Long accountId) {
        serviceAccount.getAccountById(accountId);
        return motionRepository.findByAccountIdOrderByDatemotionDesc(accountId).stream()
                .map(this::populateAccountData)
                .collect(Collectors.toList());
    }
    @Override
    public Double getCurrentBalance(Long accountId) {
        Account account = serviceAccount.getAccountById(accountId);
        Double initialBalance = Double.parseDouble(account.getInibalance());
        List<Motion> motions = motionRepository.findByAccountIdOrderByDatemotionDesc(accountId);

        if (motions.isEmpty()) {
            return initialBalance;
        }
        return motions.get(0).getMotionbalance();
    }

    private void recalculateBalances(Long accountId) {

        Account account = serviceAccount.getAccountById(accountId);
        Double balance = Double.parseDouble(account.getInibalance());

        List<Motion> allMotions = motionRepository.findByAccountId(accountId).stream()
                .sorted((m1, m2) -> m1.getDatemotion().compareTo(m2.getDatemotion()))
                .collect(Collectors.toList());

        for (Motion motion : allMotions) {
            if ("DEPOSITO".equalsIgnoreCase(motion.getTypemotion())) {
                balance += motion.getValue();
            } else if ("RETIRO".equalsIgnoreCase(motion.getTypemotion())) {
                balance -= motion.getValue();
            }
            motion.setMotionbalance(balance);
            motionRepository.save(motion);
        }
    }
    private Motion populateAccountData(Motion motion) {
        if (motion.getAccountId() != null) {
            try {
                Account account = serviceAccount.getAccountById(motion.getAccountId());
                motion.setAccount(account);
            } catch (Exception e) {
                System.out.println("Error al obtener cuenta: " + e.getMessage());
            }
        }
        return motion;
    }
}


