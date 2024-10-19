package org.microservice.doctor.service;

import org.microservice.doctor.model.dto.AddPatientDTO;
import org.microservice.doctor.model.dto.PatientDTO;

public interface PatientService {
    PatientDTO getPatientById(Long id);

    AddPatientDTO addPatient(AddPatientDTO patientDTO);
}
