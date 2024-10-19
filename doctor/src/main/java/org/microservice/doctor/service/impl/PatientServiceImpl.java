package org.microservice.doctor.service.impl;

import lombok.RequiredArgsConstructor;
import org.microservice.doctor.model.dto.AddPatientDTO;
import org.microservice.doctor.model.dto.PatientDTO;
import org.microservice.doctor.proxy.PatientProxy;
import org.microservice.doctor.service.PatientService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientProxy patientProxy;

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientProxy.getPatientById(id);
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
