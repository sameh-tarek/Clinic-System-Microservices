package org.microservice.patient.model.mapper;

import org.mapstruct.Mapper;
import org.microservice.patient.model.dto.PatientDTO;
import org.microservice.patient.model.dto.UpdatePatientDTO;
import org.microservice.patient.model.entity.Patient;

@Mapper(componentModel = ("spring"))
public interface PatientMapper {
    Patient toEntity(PatientDTO patientDTO);
    PatientDTO toDTO(Patient patient);
    Patient toUpdateEntity(UpdatePatientDTO updatePatientDTO);
}
