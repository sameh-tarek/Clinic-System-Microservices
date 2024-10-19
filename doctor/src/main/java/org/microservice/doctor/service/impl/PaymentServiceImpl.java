package org.microservice.doctor.service.impl;

import lombok.RequiredArgsConstructor;
import org.microservice.doctor.model.dto.AddPaymentDTO;
import org.microservice.doctor.model.dto.PaymentDTO;
import org.microservice.doctor.proxy.PatientProxy;
import org.microservice.doctor.proxy.PaymentProxy;
import org.microservice.doctor.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentProxy paymentProxy;
    @Override
    public PaymentDTO getPayment(String tranId) {
        return paymentProxy.getPaymentByTranId(tranId);
    }

    @Override
    public PaymentDTO addPayment(AddPaymentDTO dto) {
        return paymentProxy.addPayment(dto);
    }
}
