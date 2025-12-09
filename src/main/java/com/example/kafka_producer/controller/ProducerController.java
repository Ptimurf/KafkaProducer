package com.example.kafka_producer.controller;

import com.example.kafka_producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("producer")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProducerController {

    ProducerService service;

    @GetMapping
    void sendMessage() {
        service.sendMessage();
    }

}
