package com.gmail.clarkin200.MutaphekApp.service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("kafkaProducer")
public class KafkaProducer {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public KafkaProducer (KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic,Object message){
        kafkaTemplate.send(topic,message);
    }
}
