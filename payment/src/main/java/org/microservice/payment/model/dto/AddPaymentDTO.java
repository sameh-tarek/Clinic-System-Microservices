package org.microservice.payment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class AddPaymentDTO {
    private String tranId;
    private Double amount;
    private Long patientId;
}
