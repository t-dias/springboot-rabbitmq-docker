package com.example.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class RabbitMQConsumer {

    @RabbitListener(queues = "${queue.name}")
    private void reader(String message) {
        log.info("New Message received: " + message);
    }

}
