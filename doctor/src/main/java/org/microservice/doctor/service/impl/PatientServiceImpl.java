package org.microservice.doctor.service.impl;

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

    @Override
    public PatientDTO getPatientById(Long id) {
        log.info("getting patient details for patient id: {}", id);
        PatientDTO patientDTO = this.patientProxy.getPatientById(id);
        log.info("patient details {} " , patientDTO);
        return patientDTO;
    }

    @Override
    public AddPatientDTO addPatient(AddPatientDTO patientDTO) {
        AddPatientDTO addPatientDTO = AddPatientDTO.builder()
                .patientName(patientDTO.getPatientName())
                .patientAge(patientDTO.getPatientAge())
                .build();
        return patientProxy.addPatient(addPatientDTO);
    }
}
