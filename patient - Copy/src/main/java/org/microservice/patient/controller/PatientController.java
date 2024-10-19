package org.microservice.patient.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.microservice.patient.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/search/{name}")
    public String getPatientName(@PathVariable(name = "name") String name) {
        log.info("new request : {}", UUID.randomUUID());
        return patientService.getPatientName(name) + " Service two";
    }
}
