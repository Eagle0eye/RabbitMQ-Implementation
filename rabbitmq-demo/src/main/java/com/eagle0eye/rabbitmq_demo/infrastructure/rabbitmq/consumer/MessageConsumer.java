package com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.requests}")
    public void receiveMessage(String message) {
        log.info("receive message: {}", message);
    }

}
