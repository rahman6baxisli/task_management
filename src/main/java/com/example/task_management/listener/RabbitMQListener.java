package com.example.task_management.listener;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

 import static com.example.task_management.config.RabbitMQConfig.QUEUE_NAME;


@Component
@Slf4j
public class RabbitMQListener {

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message) {
        log.info("Received message: {}", message);
        // Process the message
    }
}

