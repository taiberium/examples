package com.example.jokerexamples.dataflow.good.service;

import com.example.jokerexamples.dataflow.good.output.BotOutput;
import com.example.jokerexamples.dataflow.good.output.EmailSender;
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

    private final BotOutput botOutput;
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
                botOutput.sendMessage(adminChatId, errorMessage);
                botOutput.sendMessage(chatId, errorMessage);
                emailService.sendAlarmEmail();
            }
            case "HANDLE" -> botOutput.sendMessage(chatId, "correct request received");
            default -> botOutput.sendMessage(chatId, "unknown message type, please try again");
        }
    }
}
