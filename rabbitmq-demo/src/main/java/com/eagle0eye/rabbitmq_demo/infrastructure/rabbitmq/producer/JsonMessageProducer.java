package com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.producer;

import com.eagle0eye.rabbitmq_demo.core.product.domain.Product;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JsonMessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageProducer.class);

    @Value("${rabbitmq.exchange.jsonrequests}")
    private String exchange;

    @Value("${rabbitmq.route.jsonrequests}")
    private String route;


    public void process(Product product) {
        try {
            String json = objectMapper.writeValueAsString(product);
            rabbitTemplate.convertAndSend(exchange, route, json);
            LOGGER.info("Send product in Json Format: {}", product.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
