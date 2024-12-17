package com.example.weather_service.controller;

import com.example.weather_service.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/fetch-city-weather/{city}")
    public String fetchWeather(@PathVariable String city) {
        weatherService.fetchAndSendWeather(city);
        return String.format("Weather data for %s has been sent to the queue.", city);
    }

}
