package org.microservice.payment.service;

import lombok.RequiredArgsConstructor;
import org.microservice.payment.model.dto.AddPaymentDTO;
import org.microservice.payment.model.dto.PaymentDTO;
import org.microservice.payment.model.entity.Payment;
import org.microservice.payment.model.mapper.PaymentMapper;
import org.microservice.payment.model.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    @Override
    public PaymentDTO getPayment(String tranId) {
        Payment payment = paymentRepository.findByTranId(tranId)
                .orElseThrow(() -> new RuntimeException());
        return paymentMapper.toDTO(payment);
    }

    public PaymentDTO addPayment(AddPaymentDTO dto) {

        String tranId = UUID.randomUUID().toString();
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .amount(dto.getAmount())
                .patientId(dto.getPatientId())
                .tranId(tranId)
                .build();
        Payment entity = this.paymentMapper.toEntity(paymentDTO);
        Payment savedPayment = this.paymentRepository.save(entity);
        return this.paymentMapper.toDTO(savedPayment);
    }


    public List<PaymentDTO> getPatientPayments(Long patientId) {
        List<Payment> payments = this.paymentRepository.findAllByPatientId(patientId);
        return this.paymentMapper.toDTOs(payments);
    }
}
