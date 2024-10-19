package org.microservice.patient.service.impl;

import lombok.RequiredArgsConstructor;
import org.microservice.patient.model.dto.PaymentDTO;
import org.microservice.patient.proxy.PaymentProxy;
import org.microservice.patient.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentProxy paymentProxy;
    @Override
    public List<PaymentDTO> getPatientPayments(Long id) {
        return paymentProxy.getPatientPayments(id);
    }
}
