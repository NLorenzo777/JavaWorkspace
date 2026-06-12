package com.example.simple_order_processor.events;

import com.example.simple_order_processor.model.Order;
import lombok.Data;

@Data
public class OrderPlacedEvent {
    private final Order order;

    public OrderPlacedEvent(Order order) {
        this.order = order;
    }
}
