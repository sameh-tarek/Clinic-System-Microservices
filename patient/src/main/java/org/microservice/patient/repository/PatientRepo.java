package org.microservice.patient.repository;

import org.microservice.patient.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends
        JpaRepository<Patient, Long> {
}
