package com.Omkar.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient
public interface PaymentClient {
    @PostMapping
    Payment createPayment();
}
