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
        return "sosweetkzn_bot";
    }

    @Override
    public String getBotToken() {
        return "806657998:AAGT7VDNRWfK_PZnKeY_y-U5n2drMr_g3SY";
    }

    abstract void handle(Update update) throws TelegramApiException;
}

