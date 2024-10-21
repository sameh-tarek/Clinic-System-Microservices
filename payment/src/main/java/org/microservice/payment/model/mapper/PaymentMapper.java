package org.microservice.payment.model.mapper;

import org.microservice.payment.model.dto.PaymentDTO;
import org.microservice.payment.model.entity.Payment;

import java.util.List;

public interface PaymentMapper {
    PaymentDTO toDTO(Payment entity);
    Payment toEntity(PaymentDTO dto);
    List<PaymentDTO> toDTOs(List<Payment> entities);
    List<Payment> toEntities(List<PaymentDTO> dtos);
}
