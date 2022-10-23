package com.example.jokerexamples.horizontal_v2.good.service;

import com.example.jokerexamples.horizontal_v2.good.output.CarTelegramProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Только бизнес логика здесь, отделенная от особенностей реализации библиотеки
 * которая позволяет нам принимать и отправлять данные
 */
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarTelegramProducer carTelegramProducer;
    private final EmailService emailService;
    @Value("${admin.chat.id:0}")
    public long adminChatId;

    public void handleMessage(long chatId, String message) {

        /*
         * We can call some additional services here
         * */

        switch (message) {
            case "ERROR" -> {
                String errorMessage = "error while handling the message";
                carTelegramProducer.sendMessage(adminChatId, errorMessage);
                carTelegramProducer.sendMessage(chatId, errorMessage);
                emailService.sendAlarmEmail();
            }
            case "HANDLE" -> carTelegramProducer.sendMessage(chatId, "correct request received");
            default -> carTelegramProducer.sendMessage(chatId, "unknown message type, please try again");
        }
    }
}
