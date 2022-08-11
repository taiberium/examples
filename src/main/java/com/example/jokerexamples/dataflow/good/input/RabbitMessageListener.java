package com.example.jokerexamples.dataflow.good.input;

import com.example.jokerexamples.dataflow.good.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Простой пример где должны находится входные данные приложения, это же позволяет очевидно переиспользовать сервисы
 */
@Component
@RequiredArgsConstructor
public class RabbitMessageListener {

    private final EmailService emailService;

    @RabbitListener
    public void listen() {
        emailService.sendAlarmEmail();
    }
}
