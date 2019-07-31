package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.LinkedHashMap;

import static ru.sosweet.keyboards.ButtonType.*;

public class MainKeyboard extends Keyboard {

    public MainKeyboard() {
        text = "Что вам интересно?";
    }

    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {

        LinkedHashMap<String, ButtonType> mainKeyboard = new LinkedHashMap<>();
        mainKeyboard.put("Кафе", CAFE);
        mainKeyboard.put("Торты на заказ", CAKEORDER);
        return new SendMessage()
                .setChatId(chat_id)
                .setText(text)
                .setReplyMarkup(setCustomKeyboard(mainKeyboard));
    }

    //main keyboard doesn't have previous keyboard
    @Override
    public ButtonType getPreviousKeyboardButton() {
        return MAIN;
    }
}
