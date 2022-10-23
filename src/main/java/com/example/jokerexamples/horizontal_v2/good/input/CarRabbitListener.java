package com.example.jokerexamples.horizontal_v2.good.input;

import com.example.jokerexamples.horizontal_v2.good.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Простой пример где должны находится входные данные приложения, это же позволяет очевидно переиспользовать сервисы
 */
@Component
@RequiredArgsConstructor
public class CarRabbitListener {

    private final EmailService emailService;

    @RabbitListener
    public void listen() {
        emailService.sendAlarmEmail();
    }
}
