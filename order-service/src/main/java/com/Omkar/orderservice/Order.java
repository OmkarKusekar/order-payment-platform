package com.Omkar.orderservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    private Long id;
    private Long userId;
    private String productName;
    private Double price;
    private OrderStatus status;

    public Order(){

    }

    public Order(Long id, Long userId, String productName, Double price,OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.status=status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public OrderStatus getStatus(){
        return status;
    }
    public void setStatus(OrderStatus status){
        this.status=status;
    }

}
