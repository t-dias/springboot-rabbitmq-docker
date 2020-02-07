package com.example.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQService {

    @Value("${exchange.name}")
    private String exchangeName;

    @Autowired
    AmqpTemplate queueSender;

    @Retryable( value = { Exception.class }, maxAttemptsExpression = "#{${rabbitmq.retry.max_attempts}}", backoff = @Backoff(delayExpression = "#{${rabbitmq.retry.backoff_delay}}"))
    @Async
    public void convertAndSend(String message) {
        log.info("Trying to send message to RabbitMQ....");
        queueSender.convertAndSend(exchangeName, "", message);
    }
}
