package com.example.weather_service.controller;

import com.example.weather_service.services.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {

    }

    @GetMapping("api/subscribe-to-weather-topic/{city}")
    public ResponseEntity<String> subscribeToWeatherTopic(@PathVariable String city) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
