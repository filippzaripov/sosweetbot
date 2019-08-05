package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.sosweet.BotProperties;

import java.util.LinkedHashMap;

import static ru.sosweet.keyboards.ButtonType.INST;

public class AboutKeyboard extends Keyboard {

    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        LinkedHashMap<String, ButtonType> keyboard = new LinkedHashMap<>();
        keyboard.put("instagram", INST);
        return new SendMessage()
                .setChatId(chat_id)
                .setText(BotProperties.ABOUT)
                .setReplyMarkup(setCustomKeyboard(keyboard, true));
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return ButtonType.CAFE;
    }
}
