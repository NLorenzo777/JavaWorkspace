package com.example.simple_order_processor.service;

import com.example.simple_order_processor.events.OrderPlacedEvent;
import com.example.simple_order_processor.events.PaymentProcessedEvent;
import com.example.simple_order_processor.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    @Autowired
    private final ApplicationEventPublisher publisher;

    // This method runs on a separate thread.
    // Simulates billing the customer. This will trigger another event.
    @Async("eventExecutor")
    @EventListener
    public void processOrder(OrderPlacedEvent event) throws InterruptedException {
        Order order = event.getOrder();

        System.out.println("[PaymentService]  Charging customer " + order.getCustomerId()
                + " $" + order.getAmount()
                + " on thread: " + Thread.currentThread().getName());

        // Simulate payment gateway latency
        Thread.sleep(3000);

        boolean success = true;
        order.setStatus(Order.Status.PAID);

        // Trigger an event that will allow the shipping of the order
        publisher.publishEvent(new PaymentProcessedEvent(order, success));
    }
}
