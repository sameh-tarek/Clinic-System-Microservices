package org.microservice.patient.service;

import org.microservice.patient.model.dto.AddPatientDTO;
import org.microservice.patient.model.dto.PatientDTO;
import org.microservice.patient.model.dto.UpdatePatientDTO;

public interface PatientService {
    AddPatientDTO addPatient(AddPatientDTO addPatientDTO);

    UpdatePatientDTO updatePatient(UpdatePatientDTO updatePatientDTO);

    void deletePatient(Long id);

    PatientDTO getPatientById(Long id);
}
