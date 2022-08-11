package com.example.jokerexamples.dataflow.bad.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TelegBot {

    @PostConstruct
    public void init(){
        TelegramBot bot = new TelegramBot("BOT_TOKEN");

        // Register for updates
        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {


                /*
                    Много много страшной логики, возможно с вызовами других сервисов!!!
                    И в итоге лапшекод с разными уровням вложенности!!!

                }*/

                // Send messages
                long chatId = update.message().chat().id();
                SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
            });
            // Send some response
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }
}
