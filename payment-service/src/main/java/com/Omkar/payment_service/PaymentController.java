package com.Omkar.payment_service;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    public ResponseEntity<Payment> createPayment(Payment payment){
        return ResponseEntity.ok(paymentService.createPayment(payment));

    }
}
