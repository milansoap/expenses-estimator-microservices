package com.example.weather_service.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue weatherQueue() {
        return new Queue("city-weather", true); // 'true' makes it durable
    }
}