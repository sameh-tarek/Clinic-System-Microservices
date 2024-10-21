package org.microservice.doctor.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.microservice.doctor.model.dto.AddPatientDTO;
import org.microservice.doctor.model.dto.PatientDTO;
import org.microservice.doctor.proxy.PatientProxy;
import org.microservice.doctor.service.PatientService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientProxy patientProxy;

    @CircuitBreaker(name = "getPatientInstance", fallbackMethod = "getDefaultPatient")
    @Override
    public PatientDTO getPatientById(Long id) {
        log.info("getting patient details for patient id: {}", id);
        PatientDTO patientDTO = this.patientProxy.getPatientById(id);
        log.info("patient details {} " , patientDTO);
        return patientDTO;
    }

    @Override
    public AddPatientDTO addPatient(AddPatientDTO patientDTO) {
        log.info("adding patient with details: {}", patientDTO);
        AddPatientDTO addPatientDTO = AddPatientDTO.builder()
                .patientName(patientDTO.getPatientName())
                .patientAge(patientDTO.getPatientAge())
                .build();
        AddPatientDTO save = patientProxy.addPatient(addPatientDTO);
        log.info("successfully added patient details {}", addPatientDTO);
        return save;
    }

    public PatientDTO getDefaultPatient (Exception e) {
        return PatientDTO.builder()
                .patientName("UNKNOWN PATIENT")
                .id(0L)
                .patientAge(0)
                .build();
    }
}
