package com.example.swaggerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swaggerdemo.model.OrderEvent;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private com.example.swaggerdemo.service.OrderEventProducer producer;

    @PostMapping("/{orderId}")
    public String createOrder(@PathVariable String orderId) {

        OrderEvent event = new OrderEvent(orderId, "ORDER_CREATED");
        producer.publishOrderEvent(event);

        return "Order event published successfully";
    }
}

