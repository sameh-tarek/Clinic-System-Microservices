package org.microservice.payment.model.repository;

import org.microservice.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends
        JpaRepository<Payment, Long> {
    Optional<Payment> findByTranId(String tranId);

    List<Payment> findAllByPatientId(Long patientId);
}
