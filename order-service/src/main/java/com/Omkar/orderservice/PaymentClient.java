package com.Omkar.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "${payment.service.url:http://payment-service:8082}")
public interface PaymentClient {
    @PostMapping("/payments")
    void createPayment( @RequestBody Payment payment);
}
