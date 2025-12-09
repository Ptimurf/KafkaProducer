package com.example.kafka_producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventSender<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    private final ObjectMapper mapper;

    private String topic = "topic-1";

    public void sendEvent(T event) {
        String key = "key1";
        try {
            String messageAsString = mapper.writer().writeValueAsString(event);
            System.out.println(messageAsString);
        } catch (Exception e) {
            System.out.println("Cant serialize value");
            return;
        }
        kafkaTemplate.send(topic, key, event);
    }
}
