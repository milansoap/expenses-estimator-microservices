package com.example.weather_service.configurations;


import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;

import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange weatherExchange() {
        return new TopicExchange("weather-exchange");
    }

    @Bean
    public Queue dynamicWeatherQueue() {
        // Generic queue for topic pattern "weather-*"
        return new Queue("weather-queue", true);
    }

    @Bean
    public Binding binding(Queue dynamicWeatherQueue, TopicExchange weatherExchange) {
        // Bind the exchange to listen to "weather-*"
        return BindingBuilder.bind(dynamicWeatherQueue).to(weatherExchange).with("weather-*");
    }
}