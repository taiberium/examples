package com.example.jokerexamples.horizontal_v2.good.output;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Purpose for Output Layer and Repository Layer is to
 * incapsulate and hide how using current library you will send data
 * or acquire the data by your request
 */
@Component
@RequiredArgsConstructor
public class BotOutput {

    private final TelegramBot bot;

    public void sendMessage(long chatId, String message){
        bot.execute(new SendMessage(chatId, message));
    }
}
