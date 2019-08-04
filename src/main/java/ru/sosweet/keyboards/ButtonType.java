package ru.sosweet.keyboards;

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
    INST("https://instagram.com/sosweet_cafe"),

    CONTACTS("contacts"),
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

    public static ButtonType getButtonTypeByCallback(String callBackData){
        for ( ButtonType button: values()
             ) {
            if (button.callBackData.equals(callBackData)){
                return button;
            }
        }
        return ERROR;
    }
}
