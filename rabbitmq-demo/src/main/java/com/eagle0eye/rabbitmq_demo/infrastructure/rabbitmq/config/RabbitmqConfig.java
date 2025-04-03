package com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    // EXCHANGES

    @Value("${rabbitmq.exchange.requests}")
    public String EXCHANGE_REQUESTS;


    // QUEUES
    @Value("${rabbitmq.queue.requests}")
    public String QUEUE_REQUESTS;

    // ROUTING KEYS

    @Value("${rabbitmq.route.requests}")
    public String ROUTING_KEY_REQUESTS;


    // create exchange
    @Bean
    DirectExchange requestExchange(){
        return new DirectExchange(EXCHANGE_REQUESTS);
    }
    @Bean
    DirectExchange responseExchange(){
        return new DirectExchange(EXCHANGE_RESPONSES);
    }
    // create queue

    @Bean
    Queue requestQueue(){
        return new Queue(QUEUE_REQUESTS,true);
    }


    @Bean
    Binding requestBinding(Queue requestQueue, DirectExchange requestExchange){
        return BindingBuilder.bind(requestQueue)
                .to(requestExchange)
                .with(ROUTING_KEY_REQUESTS);
    }


    @Value("${rabbitmq.exchange.jsonrequests}")
    public String EXCHANGE_RESPONSES;
    @Value("${rabbitmq.queue.jsonrequests}")
    public String QUEUE_RESPONSE;
    @Value("${rabbitmq.route.jsonrequests}")
    public String ROUTING_KEY_RESPONSE;
    @Bean
    Queue responseQueue() {
        return new Queue(QUEUE_RESPONSE,true);
    }
    @Bean
    Binding responseBinding(Queue responseQueue,DirectExchange responseExchange){
        return BindingBuilder.bind(responseQueue)
                .to(responseExchange)
                .with(ROUTING_KEY_RESPONSE);
    }

}