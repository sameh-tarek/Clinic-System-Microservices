package org.microservice.payment.controller;

import lombok.RequiredArgsConstructor;
import org.microservice.payment.model.dto.AddPaymentDTO;
import org.microservice.payment.model.dto.PaymentDTO;
import org.microservice.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/payment-by-tran")
    public PaymentDTO getPaymentByTranId(@RequestParam String tranId){
        return this.paymentService.getPayment(tranId);
    }

    @PostMapping("/add-payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO dto){
        return this.paymentService.addPayment(dto);
    }

    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader Long id){
        return this.paymentService.getPatientPayments(id);
    }


}
