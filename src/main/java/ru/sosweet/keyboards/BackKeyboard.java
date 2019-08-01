package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BackKeyboard extends Keyboard {

    ButtonType prevButton;

    public BackKeyboard(ButtonType prevButton) {
        this.prevButton = prevButton;
    }

    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        return new SendMessage()
                .setChatId(chat_id)
                .setText("О нас")
                .setReplyMarkup(getBackKeyboard(prevButton));
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return prevButton;
    }
}
