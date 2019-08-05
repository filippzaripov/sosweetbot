package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.sosweet.BotProperties;

import java.util.LinkedHashMap;

import static ru.sosweet.keyboards.ButtonType.LOCATION;

public class ContactsKeyboard extends Keyboard {

    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        LinkedHashMap<String, ButtonType> keyboard = new LinkedHashMap<>();
        keyboard.put("Показать на карте", LOCATION);
        return new SendMessage()
                .setChatId(chat_id)
                .setText(BotProperties.CONTACTS)
                .setReplyMarkup(setCustomKeyboard(keyboard, false));
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return ButtonType.CAFE;
    }
}
