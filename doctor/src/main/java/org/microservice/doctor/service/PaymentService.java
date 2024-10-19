package org.microservice.doctor.service;

import org.microservice.doctor.model.dto.AddPaymentDTO;
import org.microservice.doctor.model.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO getPayment(String tranId);

    PaymentDTO addPayment(AddPaymentDTO dto);
}
