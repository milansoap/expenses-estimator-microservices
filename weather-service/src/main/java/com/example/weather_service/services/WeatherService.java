package com.example.weather_service.services;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${WEATHER_API_KEY}")
    private String apiKey;

    private static final String OPEN_WEATHER_API = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public void fetchAndSendWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(OPEN_WEATHER_API, city, apiKey);

        try {

            String weatherJson = restTemplate.getForObject(url, String.class);

            if (weatherJson != null) {
                MessagePostProcessor messagePostProcessor = message -> {
                    message.getMessageProperties().setHeader("city", city);
                    return message;
                };

                rabbitTemplate.convertAndSend("weather-latest", (Object) weatherJson, messagePostProcessor);
            }
        } catch (Exception e) {
            System.err.println("Failed to fetch or send weather data for " + city + ": " + e.getMessage());
        }
    }

}