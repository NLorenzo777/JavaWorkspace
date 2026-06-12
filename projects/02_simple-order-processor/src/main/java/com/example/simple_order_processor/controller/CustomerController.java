package com.example.simple_order_processor.controller;

import com.example.simple_order_processor.model.Order;
import com.example.simple_order_processor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer/")
public class CustomerController {

    @Autowired
    OrderService orderService;

    @PostMapping("order")
    public ResponseEntity<Order> postOrder() {
        Order processedOrder = orderService.placeOrder("Noel", 25);
        return ResponseEntity.status(HttpStatus.OK).body(processedOrder);
    }
}
