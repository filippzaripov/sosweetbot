package ru.sosweet;

import java.util.Properties;

public class BotProperties {

    private static final Properties proxyProperties = FilesReader.getProperties("src/main/resources/proxy.properties");
    private static final String aboutPath = "src/main/resources/text/about";
    private static final String contactsPath = "src/main/resources/text/contacts";
    private static final String promotionsPath = "src/main/resources/text/promotions";
    private static final Properties telegramProperties = FilesReader.getProperties("src/main/resources/telegram.properties");
    private static final Properties otherProperties = FilesReader.getProperties("src/main/resources/otherProps.properties");

    public static String PROXY_HOST;
    public static String PROXY_PORT;
    public static String PROXY_SET;

    public static final String ABOUT;
    public static final String CONTACTS;
    public static final String PROMOTIONS;

    public static String BOT_USERNAME;
    public static String BOT_TOKEN;

    public static String PROPS_INSTAGRAM;

    static {
        if (proxyProperties != null) {
            PROXY_HOST = proxyProperties.getProperty("socksProxyHost");
            PROXY_PORT = proxyProperties.getProperty("socksProxyPort");
            PROXY_SET = proxyProperties.getProperty("proxySet");
        } else {
            PROXY_HOST = "127.0.0.1";
            PROXY_PORT = "1234";
            PROXY_SET = "false";
        }

        ABOUT = FilesReader.readText(aboutPath);
        CONTACTS = FilesReader.readText(contactsPath);
        PROMOTIONS = FilesReader.readText(promotionsPath);

        BOT_USERNAME = telegramProperties.getProperty("username");
        BOT_TOKEN = telegramProperties.getProperty("token");

        PROPS_INSTAGRAM = otherProperties.getProperty("instagram");

    }

    private BotProperties() {


    }


}
