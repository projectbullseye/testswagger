package com.example.swaggerdemo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderEvent {

    private String orderId;
    private String type;
    private LocalDateTime timestamp;

    public OrderEvent() {}

    public OrderEvent(String orderId, String type) {
        this.orderId = orderId;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    // getters & setters
}

