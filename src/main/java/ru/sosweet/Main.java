package ru.sosweet;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static ru.sosweet.BotProperties.*;


public class Main {
    private final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        setProperties();
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new MainHandlerBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static void setProperties() {
        if (PROXY_SET.equals("true")) {
            System.getProperties().put("proxySet", PROXY_SET);
            System.getProperties().put("socksProxyHost", PROXY_HOST);
            System.getProperties().put("socksProxyPort", PROXY_PORT);
        }
    }
}

