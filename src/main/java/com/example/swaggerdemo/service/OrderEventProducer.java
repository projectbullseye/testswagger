package com.example.swaggerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.swaggerdemo.model.OrderEvent;

@Service
public class OrderEventProducer {

    private static final String TOPIC = "order-events";

    @Autowired(required = false)
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void publishOrderEvent(OrderEvent event) {
        if (kafkaTemplate == null) {
            // Kafka not configured in this environment; skip publishing
            return;
        }
        kafkaTemplate.send(TOPIC, event.getOrderId(), event);
    }
}

