package ru.sosweet;

import java.util.Properties;

public class BotProperties {

    private static final Properties proxyProperties = FilesReader.getProperties("src/main/resources/proxy.properties");
    private static final String aboutPath = "src/main/resources/text/about";
    private static final String contactsPath = "src/main/resources/text/contacts";
    private static final String promotionsPath = "src/main/resources/text/promotions";

    public static final String PROXY_HOST;
    public static final String PROXY_PORT;
    public static final String PROXY_SET;

    public static final String ABOUT;
    public static final String CONTACTS;
    public static final String PROMOTIONS;

    static {
        PROXY_HOST = proxyProperties.getProperty("socksProxyHost");
        PROXY_PORT = proxyProperties.getProperty("socksProxyPort");
        PROXY_SET = proxyProperties.getProperty("proxySet");

        ABOUT = FilesReader.readText(aboutPath);
        CONTACTS = FilesReader.readText(contactsPath);
        PROMOTIONS = FilesReader.readText(promotionsPath);

    }

    private BotProperties() {


    }


}
