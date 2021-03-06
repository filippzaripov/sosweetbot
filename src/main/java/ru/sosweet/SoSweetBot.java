package ru.sosweet;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class SoSweetBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        try {
            handle(update);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BotProperties.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotProperties.BOT_TOKEN;
    }

    abstract void handle(Update update) throws TelegramApiException;
}

