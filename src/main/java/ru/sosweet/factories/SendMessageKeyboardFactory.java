package ru.sosweet.factories;

import ru.sosweet.keyboards.*;

public class SendMessageKeyboardFactory {

    private static final Keyboard mainKeyboard = new MainKeyboard();
    private static final Keyboard cakeTypeKeyboard = new CakeTypeKeyboard();
    private static final Keyboard cafeKeyboard = new CafeKeyboard();
    private static final Keyboard emptyKeyboard = new ErrorMessageKeyboard();

    public static Keyboard getKeyboard(ButtonType callBackData) {
        switch (callBackData) {
            case MAIN:
                return mainKeyboard;
            case CAKEORDER:
                return cakeTypeKeyboard;
            case CAFE:
                return cafeKeyboard;
            default:
                return emptyKeyboard;
        }
    }


}
