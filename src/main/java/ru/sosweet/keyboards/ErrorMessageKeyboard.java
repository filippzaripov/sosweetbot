package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ErrorMessageKeyboard extends Keyboard {
    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        return new SendMessage()
                .setText("Произошла неожиданная ошибка")
                .setChatId(chat_id);
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return ButtonType.MAIN;
    }
}
