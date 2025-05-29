package com.tcs.retomicroservices.controller;

import com.tcs.retomicroservices.entity.Person;
import com.tcs.retomicroservices.service.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private ServicePerson servicePerson;

    @PostMapping
    public ResponseEntity<String> postPerson(@RequestBody Person person) {

        if (servicePerson.isIdentificationExist(person.getIdentification())) {
            return ResponseEntity.badRequest().body("Cédula ya registrada ingrese otra.");
        }
        if (!person.getIdentification().matches("\\d+")){
            return ResponseEntity.badRequest().body("La cedula solo debe contener numeros");
        }
        if (person.getIdentification().length() != 10) {
            return ResponseEntity.badRequest().body("La cedula debe tener 10 dígitos.");
        }
        int provincia = Integer.parseInt(person.getIdentification().substring(0, 2));
        if (provincia < 1 || provincia > 30){
            return ResponseEntity.badRequest().body("Error cedula");
        }

        if (!person.getAgeperson().matches("\\d+")){
            return ResponseEntity.badRequest().body("La edad solo debe ser numerica");
        }

        if (!person.getPhoneperson().matches("\\d+")){
            return ResponseEntity.badRequest().body("Ingrese solo datos numericos para el numero telefonico");
        }
        if (person.getPhoneperson().length() != 10) {
            return ResponseEntity.badRequest().body("Número de teléfono debe tener 10 dígitos.");
        }

        servicePerson.postPerson(person);
        return ResponseEntity.ok("Persona agregada correctamente.");
    }
    @GetMapping
    public List<Person> getPerson() {
        return servicePerson.getPerson();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") long idPerson) {
        servicePerson.deletePerson(idPerson);
        return ResponseEntity.ok("Se eliminó el registro de la persona.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> putPerson(@PathVariable("id") long idPerson,
                                            @RequestBody Person updatedPerson) {

        if (servicePerson.isIdentificationExist(updatedPerson.getIdentification()) &&
                !updatedPerson.getIdentification().equals(servicePerson.getPersonById(idPerson).getIdentification())) {
            return ResponseEntity.badRequest().body("Esta no es cedula ingrese su cedula.");
        }
        if (updatedPerson.getIdentification().length() != 10) {
            return ResponseEntity.badRequest().body("La cedula debe tener 10 dígitos.");
        }
        if (!updatedPerson.getIdentification().matches("\\d+")){
            return ResponseEntity.badRequest().body("La cedula solo debe contener numeros");
        }

        int provincia = Integer.parseInt(updatedPerson.getIdentification().substring(0, 2));
        if (provincia < 1 || provincia > 30) {
            return ResponseEntity.badRequest().body("La cédula debe iniciar con un código de provincia válido (01 a 30).");
        }

        if (!updatedPerson.getAgeperson().matches("\\d+")){
            return ResponseEntity.badRequest().body("La edad solo debe ser numerica");
        }
        if (!updatedPerson.getPhoneperson().matches("\\d+")){
            return ResponseEntity.badRequest().body("Ingrese solo datos numericos para el numero telefonico");
        }
        if (updatedPerson.getPhoneperson().length() != 10) {
            return ResponseEntity.badRequest().body("Número de teléfono debe tener 10 dígitos.");
        }

        servicePerson.putPerson(idPerson, updatedPerson);
        return ResponseEntity.ok("Se actualizó el registro.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long idPerson) {
        Person person = servicePerson.getPersonById(idPerson);
        return ResponseEntity.ok(person);
    }
}