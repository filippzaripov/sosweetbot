package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.sosweet.BotProperties;

import java.util.Collections;
import java.util.LinkedHashMap;

public class PromotionsKeyboard extends Keyboard {
    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        return new SendMessage()
                .setChatId(chat_id)
                .setText(BotProperties.PROMOTIONS)
                .setReplyMarkup(setCustomKeyboard(new LinkedHashMap<>(), false));
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return ButtonType.CAFE;
    }
}
