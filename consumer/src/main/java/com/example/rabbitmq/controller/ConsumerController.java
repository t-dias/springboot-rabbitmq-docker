package com.example.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
class ConsumerController {

    @GetMapping
    ResponseEntity<String> get() {
        return ResponseEntity.ok("This is just a example");
    }

}