package com.example.bot.impl;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Singleton
public class FindMiBot extends TelegramLongPollingBot {

    private static final Logger log = LoggerFactory.getLogger(FindMiBot.class);

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.api-token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // do nothing
    }
}
