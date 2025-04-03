package com.eagle0eye.rabbitmq_demo.core.rabbitmq.appliction;

import com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RabbitmqService {

    private final MessageProducer producer ;

    public String create(String message) {
        producer.send(message);
        return message;
    }
}
