package org.microservice.doctor.proxy;

import org.microservice.doctor.model.dto.AddPatientDTO;
import org.microservice.doctor.model.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PATIENT-SERVICE", path = "/patient")
public interface PatientProxy {

    @GetMapping("/patients/{id}")
    public PatientDTO getPatientById(@PathVariable(name = "id") Long id);

    @PostMapping("/patients")
    public AddPatientDTO addPatient(@RequestBody AddPatientDTO addPatientDTO);
}
