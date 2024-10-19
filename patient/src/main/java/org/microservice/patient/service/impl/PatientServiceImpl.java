package org.microservice.patient.service.impl;

import lombok.RequiredArgsConstructor;
import org.microservice.patient.model.dto.AddPatientDTO;
import org.microservice.patient.model.dto.PatientDTO;
import org.microservice.patient.model.dto.UpdatePatientDTO;
import org.microservice.patient.model.entity.Patient;
import org.microservice.patient.model.mapper.PatientMapper;
import org.microservice.patient.repository.PatientRepo;
import org.microservice.patient.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final PatientMapper patientMapper;

    @Override
    public AddPatientDTO addPatient(AddPatientDTO addPatientDTO) {
        Patient patient = Patient.builder()
                .patientName(addPatientDTO.getPatientName())
                .patientAge(addPatientDTO.getPatientAge())
                .build();
        patientRepo.save(patient);

        return addPatientDTO;
    }

    @Override
    public UpdatePatientDTO updatePatient(UpdatePatientDTO updatePatientDTO) {
        Patient patient = patientMapper.toUpdateEntity(updatePatientDTO);
        patientRepo.save(patient);
        return updatePatientDTO;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepo.deleteById(id);
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException());

        return patientMapper.toDTO(patient);
    }
}
