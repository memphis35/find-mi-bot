package com.example.bot;

import com.example.bot.impl.FindMiBot;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Singleton
public class TelegramBotImpl implements TelegramBot {

    private static final Logger log = LoggerFactory.getLogger(TelegramBotImpl.class);

    private final FindMiBot findMiBot;

    @Inject
    public TelegramBotImpl(FindMiBot findMiBot) {
        this.findMiBot = findMiBot;
    }

    @Override
    public void start() {
        try {
            final TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(findMiBot);
            log.info("Bot has been run");
        } catch (TelegramApiException e) {
            log.error("An error occurred while starting: {}", e.getMessage(), e);
            System.exit(1);
        }
    }
}
