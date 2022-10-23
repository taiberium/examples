package com.example.jokerexamples.horizontal_v2.good.input;

import com.example.jokerexamples.horizontal_v2.good.service.CarService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * Martin Fowler
 * In MVC pattern
 * The controller's job is to take the user's input and figure out what to do with it.
 * <p>
 * Формально, всё что принимает решение о последующих шагах на основе входных данных является контроллером
 * Задача контроля приема данных сводится к получению сообщения, валидации этого сообщения, конвертации в
 * формат API ServiceLayer и отправка в ServiceLayer
 * <p>
 * <p>
 * Bot, WebSocket Handler или RabbitListener это не формат взаимодействия запрос-ответ,
 * даже если сейчас на один запрос может быть ответ, в будущем на один запрос может понадобится 3 ответа
 * по этой причине в Handler сразу зашивать Response часто не корректно и лучше их разделить
 */
@Controller
@RequiredArgsConstructor
public class CarTelegramListener {

    private final TelegramBot bot;
    private final CarService carService;

    @PostConstruct
    public void init() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::handleMessage);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    /**
     * Особенности библиотеки взаимодействия с ботом и валидация формата сообщений не должна уйти ниже уровня контроллера
     */
    public void handleMessage(Update botUpdate) {

        long chatId = botUpdate.message().chat().id();
        String messageText = botUpdate.message().text();

        if (StringUtils.hasText(messageText)) {
            carService.handleMessage(chatId, messageText);
        }
    }

}
