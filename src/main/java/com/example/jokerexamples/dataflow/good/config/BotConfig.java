package com.example.jokerexamples.dataflow.good.config;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramBotConfig {

    @Value("${bot.token:token}")
    public String botToken;

    @Bean
    public TelegramBot telegramBot() {
        return new TelegramBot(botToken);
    }
}
