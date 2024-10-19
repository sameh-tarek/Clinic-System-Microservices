package org.microservice.doctor.controller;

import lombok.RequiredArgsConstructor;
import org.microservice.doctor.model.dto.AddPatientDTO;
import org.microservice.doctor.model.dto.PatientDTO;
import org.microservice.doctor.service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patients")
    public PatientDTO getPatientById (@RequestParam Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/patients")
    public AddPatientDTO addPatient (@RequestBody AddPatientDTO patientDTO) {
        return patientService.addPatient(patientDTO);
    }
}
