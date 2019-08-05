package ru.sosweet.factories;

import ru.sosweet.keyboards.*;

public class SendMessageKeyboardFactory {

    private static final Keyboard mainKeyboard = new MainKeyboard();
    private static final Keyboard cakeTypeKeyboard = new CakeTypeKeyboard();
    private static final Keyboard cafeKeyboard = new CafeKeyboard();
    private static final Keyboard emptyKeyboard = new ErrorMessageKeyboard();
    private static final Keyboard aboutKeyboard = new AboutKeyboard();
    private static final Keyboard contactsKeyboard = new ContactsKeyboard();

    public static Keyboard getKeyboard(ButtonType callBackData) {
        switch (callBackData) {
            case MAIN:
                return mainKeyboard;
            case CAKEORDER:
                return cakeTypeKeyboard;
            case CAFE:
                return cafeKeyboard;
            case ABOUT:
                return aboutKeyboard;
            case CONTACTS:
                return contactsKeyboard;
            default:
                return emptyKeyboard;
        }
    }

    public static Keyboard getBackKeyboard(ButtonType prevButton) {
        return new BackKeyboard(prevButton);
    }


}
