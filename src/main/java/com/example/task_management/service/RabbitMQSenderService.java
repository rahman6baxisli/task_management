package com.example.task_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
 import static com.example.task_management.config.RabbitMQConfig.EXCHANGE_NAME;
import static com.example.task_management.config.RabbitMQConfig.ROUTING_KEY;


@Component
@RequiredArgsConstructor
public class RabbitMQSenderService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
    }
}


