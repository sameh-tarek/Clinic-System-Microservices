package org.microservice.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    @Override
    public PaymentDTO getPayment(String tranId) {
        log.info("get payment with tranId: {}", tranId);
        Payment payment = paymentRepository.findByTranId(tranId)
                .orElseThrow(() -> new RuntimeException());
        log.info("payment with tran id: {}, info {}", tranId, payment);
        return paymentMapper.toDTO(payment);
    }

    public PaymentDTO addPayment(AddPaymentDTO dto) {
        log.info("adding payment details {}", dto);

        String tranId = UUID.randomUUID().toString();
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .amount(dto.getAmount())
                .patientId(dto.getPatientId())
                .tranId(tranId)
                .build();

        log.info("payment dto {}", paymentDTO);
        Payment entity = this.paymentMapper.toEntity(paymentDTO);
        Payment savedPayment = this.paymentRepository.save(entity);
        log.info("payment added successfully {}", savedPayment);

        return this.paymentMapper.toDTO(savedPayment);
    }


    public List<PaymentDTO> getPatientPayments(Long patientId) {
        List<Payment> payments = this.paymentRepository.findAllByPatientId(patientId);
        return this.paymentMapper.toDTOs(payments);
    }
}
