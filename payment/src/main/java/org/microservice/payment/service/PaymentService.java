package org.microservice.payment.service;

import org.microservice.payment.model.dto.AddPaymentDTO;
import org.microservice.payment.model.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    public PaymentDTO getPayment(String tranId);

    PaymentDTO addPayment(AddPaymentDTO dto);

    List<PaymentDTO> getPatientPayments(Long id);
}
