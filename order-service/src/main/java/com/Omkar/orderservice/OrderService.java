package com.Omkar.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentClient paymentClient;
    public Order createOrder( @RequestBody Order order){
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder=orderRepository.save(order);

        Payment payment=new Payment();
        payment.setId(savedOrder.getId());
        payment.setOrderId(savedOrder.getId());
        payment.setAmount(savedOrder.getPrice());
        payment.setStatus(PaymentStatus.PENDING);

        paymentClient.createPayment(payment);
        return savedOrder;
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId){
        return orderRepository.findByUserId(userId);
    }


    public Order updateOrderStatus(Long orderId,OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));
        order.setStatus(status);
        return orderRepository.save(order);

    }
}
