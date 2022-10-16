package com.example.jokerexamples.horizontal.bad.bot;

import com.example.jokerexamples.horizontal.bad.service.DecisionService;
import com.example.jokerexamples.horizontal.bad.service.EmailService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * Простой пример как Ботов часто переносят в 'bot' пакеты,
 * никак не вяжется ни с 3-х звенкой, ни с Гексагоналкой
 */
@Service
@RequiredArgsConstructor
public class TelegramAdapter {


    private final DecisionService decisionService;
    private final EmailService emailService;
    @Value("${admin.chat.id:0}")
    public long adminChatId;
    @Value("${bot.token:token}")
    public String botToken;
    private TelegramBot bot;


    @PostConstruct
    public void init() {
        // Инициализцаия бота
        TelegramBot.Builder builder = new TelegramBot.Builder(botToken);
        bot = new TelegramBot("BOT_TOKEN");

        // Прием входящих сообщений
        bot.setUpdatesListener(updates -> {
            updates.forEach(botUpdate -> {

                //Конвертация, валидация и обработка сообщения
                long chatId = botUpdate.message().chat().id();
                String messageText = botUpdate.message().text();

                if (StringUtils.hasText(messageText)) {

                    //Бизнес логика в сервисах и самописная логика бота
                    decisionService.doSomeLogic();

                    switch (messageText) {
                        case "ERROR" -> {
                            String errorMessage = "error while handling the message";
                            decisionService.doSomeLogic();

                            // Логика отправки исходящих сообщений
                            bot.execute(new SendMessage(adminChatId, errorMessage));
                            bot.execute(new SendMessage(chatId, errorMessage));
                            emailService.sendEmail();
                        }
                        case "HANDLE" -> bot.execute(new SendMessage(chatId, "correct request received"));
                        default -> bot.execute(new SendMessage(chatId, "unknown message type, please try again"));
                    }
                }
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
