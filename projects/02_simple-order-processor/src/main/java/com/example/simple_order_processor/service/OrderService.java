package com.example.simple_order_processor.service;

import com.example.simple_order_processor.events.OrderPlacedEvent;
import com.example.simple_order_processor.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    @Autowired
    private final ApplicationEventPublisher eventPublisher;

    public Order placeOrder(String customerId, double amount) {
        // 1. Create the Order
        Order orderCreated = new Order(customerId, amount);

        System.out.println("[OrderService]    Order Created: " + orderCreated.getId() + " on thread: " + Thread.currentThread().getName());

        // 2. Publish - all listeners are triggered
        // This call returns immediately with @Async on listeners.
        eventPublisher.publishEvent(new OrderPlacedEvent(orderCreated));

        // 3. Return to the caller without waiting for listeners to finish
        return orderCreated;
    }

}
