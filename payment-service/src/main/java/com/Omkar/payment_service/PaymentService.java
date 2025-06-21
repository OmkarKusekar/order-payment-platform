package com.Omkar.payment_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        payment.setStatus(PaymentStatus.SUCCESS); // Mock payment processing
        return (Payment) paymentRepository.save(payment);
    }
}
