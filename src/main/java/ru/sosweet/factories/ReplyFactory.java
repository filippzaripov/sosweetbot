package ru.sosweet.factories;

import ru.sosweet.keyboards.ButtonType;

public class ReplyFactory {

    //todo доделать нормальные свитчи
    public static Object getReply(ButtonType callBackData, long chat_id) {
        switch (callBackData) {
            case MENU:
                return PhotoFactory.getPhoto(callBackData, chat_id);
            default:
                return SendMessageKeyboardFactory.getKeyboard(callBackData);
        }
    }
}
