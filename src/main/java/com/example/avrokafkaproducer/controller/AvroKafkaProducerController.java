package com.example.avrokafkaproducer.controller;

import com.example.avro.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class AvroKafkaProducerController {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public AvroKafkaProducerController(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody final User body) {

        kafkaTemplate.sendDefault(body);

        return "Published avro message successfully";
    }
}
