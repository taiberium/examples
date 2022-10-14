package com.example.jokerexamples.horizontal.bad.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Простой пример где часто в реальных приложениях бывают листенеры очередей
 */
@Component
@RequiredArgsConstructor
public class RabbitMessageListener {

    @RabbitListener
    public void listen(){}
}
