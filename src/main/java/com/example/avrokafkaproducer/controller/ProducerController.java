package com.example.avrokafkaproducer.controller;

import com.example.avro.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ProducerController {

    private static final String TOPIC = "my-topic";
    private final KafkaTemplate<String, User> kafkaTemplate;

    public ProducerController(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{name}")
    public String publish(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
}
