package com.tcs.retomicroservices2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Motion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmotion", nullable = false)
    private Long idmotion;

    private LocalDateTime datemotion;
    private String typemotion;
    private Double value;
    private Double motionbalance;

    // Relación con la cuenta
    @Column(name = "account_id")
    private Long accountId;

    @Transient
    private Account account;
}