package com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.consumer;

import com.eagle0eye.rabbitmq_demo.core.product.domain.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JsonMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageConsumer.class);

    private final ObjectMapper objectMapper;  // Injected instead of manual instantiation

    @RabbitListener(queues = "${rabbitmq.queue.jsonrequests}")
    public void receiveJsonMessage(String jsonMessage) {
        try {
            Product product = objectMapper.readValue(jsonMessage, Product.class);
            LOGGER.info("✅ Received product in JSON message: {}", product.toString());

        } catch (JsonProcessingException e) {
            LOGGER.error("❌ JSON Processing Error: Invalid JSON format - {}", jsonMessage, e);
        } catch (Exception e) {
            LOGGER.error("❌ Error while processing message: {}", jsonMessage, e);
        }
    }
}
