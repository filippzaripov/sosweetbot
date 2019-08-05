package ru.sosweet.keyboards;

import static ru.sosweet.BotProperties.PROPS_INSTAGRAM;

public enum ButtonType {
    ERROR("error"),
    BACK("back"),

    MAIN("main"),

    /**
     * О Кафе
     */
    CAFE("cafe"),

    MENU("menu"),

    ABOUT("about"),
    INST(PROPS_INSTAGRAM),

    CONTACTS("contacts"),
    LOCATION("location"),

    PROMOTIONS("promotions"),

    /**
     * Заказ тортов
     */
    CAKEORDER("cakeorder"),

    CAKE("cake"),
    CHEESECAKE("cheesecake"),
    DESSERT("dessert");


    public String callBackData;

    ButtonType(String callBackData) {
        this.callBackData = callBackData;
    }

    public static ButtonType getButtonTypeByCallback(String callBackData) {
        for (ButtonType button : values()
        ) {
            if (button.callBackData.equals(callBackData)) {
                return button;
            }
        }
        return ERROR;
    }
}
