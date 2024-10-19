package org.microservice.doctor.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddPaymentDTO {
    private String tranId;
    private Double amount;
    private Long patientId;
}
