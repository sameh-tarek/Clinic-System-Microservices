package org.microservice.doctor.controller;

import lombok.RequiredArgsConstructor;
import org.microservice.doctor.model.dto.AddPaymentDTO;
import org.microservice.doctor.model.dto.PaymentDTO;
import org.microservice.doctor.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PatientPaymentController {
    private final PaymentService paymentService;

    @GetMapping("/payment-by-tran")
    public PaymentDTO getPaymentByTranId(@RequestParam String tranId){
        return this.paymentService.getPayment(tranId);
    }

    @PostMapping("/add-payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO dto){
        return this.paymentService.addPayment(dto);
    }
}
