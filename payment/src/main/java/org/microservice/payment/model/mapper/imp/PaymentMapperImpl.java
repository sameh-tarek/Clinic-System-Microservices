package org.microservice.payment.model.mapper.imp;

import org.microservice.payment.model.dto.PaymentDTO;
import org.microservice.payment.model.entity.Payment;
import org.microservice.payment.model.mapper.PaymentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public PaymentDTO toDTO(Payment entity) {
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .patientId(entity.getPatientId())
                .tranId(entity.getTranId())
                .build();
        return paymentDTO;
    }

    @Override
    public Payment toEntity(PaymentDTO dto) {
        Payment payment = Payment.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .patientId(dto.getPatientId())
                .tranId(dto.getTranId())
                .build();
        return payment;
    }

    @Override
    public List<PaymentDTO> toDTOs(List<Payment> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PaymentDTO> list = new ArrayList<PaymentDTO>( entities.size() );
        for ( Payment payment : entities ) {
            list.add( toDTO( payment ) );
        }

        return list;
    }

    @Override
    public List<Payment> toEntities(List<PaymentDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Payment> list = new ArrayList<Payment>( dtos.size() );
        for ( PaymentDTO paymentDTO : dtos ) {
            list.add( toEntity( paymentDTO ) );
        }

        return list;
    }
}
