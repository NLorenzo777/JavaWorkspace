package com.example.simple_order_processor.events;

import com.example.simple_order_processor.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderShippedEvent {
    private final Order order;
    private final String trackingNumber;
}