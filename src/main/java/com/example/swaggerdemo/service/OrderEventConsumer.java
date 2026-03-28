package com.example.swaggerdemo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.swaggerdemo.model.OrderEvent;

@Service
public class OrderEventConsumer {

    @KafkaListener(topics = "order-events", groupId = "demo-group")
    public void consume(OrderEvent event) {

        System.out.println("Received Order Event:");
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Type: " + event.getType());
        System.out.println("Time: " + event.getTimestamp());

        // business processing logic
    }
}

