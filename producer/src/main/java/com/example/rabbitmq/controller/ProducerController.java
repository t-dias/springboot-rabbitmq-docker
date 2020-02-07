package com.example.rabbitmq.controller;

import com.example.rabbitmq.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
class ProducerController {

    @Autowired
    RabbitMQService rabbitMQServiceService;

    @GetMapping
    ResponseEntity<String> sendMessage(
            @RequestParam(value = "message", defaultValue = "default.message") String message) {
        this.rabbitMQServiceService.convertAndSend(message);
        return ResponseEntity.ok(String.format("Message \"%s\" sent to RabbitMQ!", message));
    }

}
