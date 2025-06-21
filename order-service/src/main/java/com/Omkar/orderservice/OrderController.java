package com.Omkar.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Order>>getOrderByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }
    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId,@RequestParam OrderStatus status){
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId ,status));

    }
    
}
