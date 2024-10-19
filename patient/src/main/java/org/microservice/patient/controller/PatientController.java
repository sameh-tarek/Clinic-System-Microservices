package org.microservice.patient.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.microservice.patient.model.dto.AddPatientDTO;
import org.microservice.patient.model.dto.PatientDTO;
import org.microservice.patient.model.dto.PaymentDTO;
import org.microservice.patient.model.dto.UpdatePatientDTO;
import org.microservice.patient.service.PatientService;
import org.microservice.patient.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final PaymentService paymentService;

    @PostMapping
    public AddPatientDTO addPatient (@RequestBody AddPatientDTO addPatientDTO){
        return patientService.addPatient(addPatientDTO);
    }

    @PutMapping
    public UpdatePatientDTO updatePatient (@RequestBody UpdatePatientDTO updatePatientDTO){
        return patientService.updatePatient(updatePatientDTO);
    }

    @DeleteMapping
    public void deletePatient (@RequestParam Long id){
        patientService.deletePatient(id);
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById (@PathVariable(name = "id") Long id){
        return patientService.getPatientById(id);
    }

    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader Long id){
        return this.paymentService.getPatientPayments(id);
    }
}
