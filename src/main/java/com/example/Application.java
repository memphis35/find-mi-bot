package com.example;

import com.example.bot.TelegramBot;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
        ApplicationContext applicationContext = ApplicationContext.run();
        applicationContext.getBean(TelegramBot.class).start();
    }
}