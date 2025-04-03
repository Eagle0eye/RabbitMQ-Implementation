package com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.producer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

    MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbitmq.exchange.requests}")
    private String exchange;
    @Value("${rabbitmq.route.requests}")
    private String routingKey;

    public void send(String message) {
        LOGGER.info("send message: {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
