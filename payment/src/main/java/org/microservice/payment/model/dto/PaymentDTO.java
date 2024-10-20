package org.microservice.payment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentDTO {
    private Long id;
    private String tranId;
    private Double amount;
    private Long patientId;
}
