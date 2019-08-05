package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.LinkedHashMap;

import static ru.sosweet.keyboards.ButtonType.*;

public class CafeKeyboard extends Keyboard {
    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        LinkedHashMap<String, ButtonType> mainKeyboard = new LinkedHashMap<>();
        mainKeyboard.put("О нас", ABOUT);
        mainKeyboard.put("Контакты", CONTACTS);
        mainKeyboard.put("Акции", PROMOTIONS);
        mainKeyboard.put("Меню", MENU);
        return new SendMessage()
                .setChatId(chat_id)
                .setText("Кафе")
                .setReplyMarkup(setCustomKeyboard(mainKeyboard,false));
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return MAIN;
    }
}
