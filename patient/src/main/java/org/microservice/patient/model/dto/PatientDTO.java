package org.microservice.patient.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientDTO {
    private Long id;
    private String patientName;
    private Integer patientAge;
}
