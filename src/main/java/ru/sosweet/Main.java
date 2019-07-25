package ru.sosweet;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


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
        try (FileInputStream input = new FileInputStream("src/main/resources/proxy.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            System.getProperties().put("proxySet", properties.getProperty("proxySet"));
            System.getProperties().put("socksProxyHost", properties.getProperty("socksProxyHost"));
            System.getProperties().put("socksProxyPort", properties.getProperty("socksProxyPort"));
        } catch (FileNotFoundException e) {
            log.error("Proxy file not found");
        } catch (IOException e) {
            log.error("Error while reading property file");
        }
    }
}

