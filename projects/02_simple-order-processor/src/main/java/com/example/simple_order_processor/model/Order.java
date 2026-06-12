package com.example.simple_order_processor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Order {
    public enum Status { PENDING, PAID, SHIPPED, CANCELLED}

    private final String id;
    private final String customerId;
    private final double amount;
    private Status status;

    public Order(String customerId, double amount) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.amount = amount;
        this.status = Status.PENDING;
    }

}
