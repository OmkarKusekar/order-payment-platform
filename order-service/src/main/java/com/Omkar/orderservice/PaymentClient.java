package com.Omkar.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient
public interface PaymentClient {
    @PostMapping("/payments")
    Payment createPayment( @RequestBody Payment payment);
}
