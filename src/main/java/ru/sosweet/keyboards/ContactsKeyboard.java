package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.LinkedHashMap;

import static ru.sosweet.keyboards.ButtonType.INST;

public class ContactsKeyboard extends Keyboard {
    private static String contacts = null;
    private static final String aboutFilePath = "src/main/resources/text/contacts";

    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        if (contacts == null) {
            contacts = readTextFile(aboutFilePath);
        }
        return new SendMessage()
                .setChatId(chat_id)
                .setText(contacts);
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return ButtonType.CAFE;
    }
}
