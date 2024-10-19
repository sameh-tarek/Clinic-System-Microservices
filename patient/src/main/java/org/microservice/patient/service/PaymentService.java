package org.microservice.patient.service;

import org.microservice.patient.model.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getPatientPayments(Long id);
}
