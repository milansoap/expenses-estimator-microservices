package com.example.notification_service.controllers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class NotificationController {

    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    @RabbitListener(queues = "weather-latest")
    public void listenToWeatherLatest(Message message) {
        try {

            MessageProperties properties = message.getMessageProperties();
            String city = (String) properties.getHeaders().get("city");

            if (city != null) {
                String queueName = "weather-" + city.toLowerCase();

                SseEmitter emitter = emitters.get(queueName);
                if (emitter != null) {
                    String messageBody = new String(message.getBody());

                    emitter.send(SseEmitter.event()
                            .name("weather-update")
                            .data(messageBody));

                    System.out.println("Message forwarded to SSE for city: " + city);
                } else {
                    System.err.println("No emitter found for city: " + city);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to send SSE: " + e.getMessage());
        }
    }

    @GetMapping(value = "/get-weather-notifications/{city}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getWeatherNotifications(@PathVariable String city) {
        String queueName = "weather-" + city.toLowerCase();

        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        emitters.put(queueName, emitter);

        System.out.println("SSE connected for city: " + city);

        try {
            emitter.send(SseEmitter.event().name("keep-alive").data("Connection established"));
        } catch (IOException e) {
            emitter.complete();
            emitters.remove(queueName);
        }

        emitter.onCompletion(() -> emitters.remove(queueName));
        emitter.onTimeout(() -> emitters.remove(queueName));

        return emitter;
    }
}
