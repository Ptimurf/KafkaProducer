package com.example.kafka_producer.service;

import com.example.kafka_producer.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
@Service
public class ProducerService {

    KafkaEventSender<Message> kafkaEventSender;

    public void sendMessage() {
        Message message = new Message("someText", "someDescr");
        kafkaEventSender.sendEvent(message);
    }

}
