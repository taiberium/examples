package com.example.jokerexamples.horizontal_v2.good.service;

import com.example.jokerexamples.horizontal_v2.good.output.TelegramCarProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Только бизнес логика здесь, отделенная от особенностей реализации библиотеки
 * которая позволяет нам принимать и отправлять данные
 */
@Service
@RequiredArgsConstructor
public class BotDecisionService {

    private final TelegramCarProducer telegramCarProducer;
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
                telegramCarProducer.sendMessage(adminChatId, errorMessage);
                telegramCarProducer.sendMessage(chatId, errorMessage);
                emailService.sendAlarmEmail();
            }
            case "HANDLE" -> telegramCarProducer.sendMessage(chatId, "correct request received");
            default -> telegramCarProducer.sendMessage(chatId, "unknown message type, please try again");
        }
    }
}
