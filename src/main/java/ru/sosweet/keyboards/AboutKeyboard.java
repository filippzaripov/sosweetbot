package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

import static ru.sosweet.keyboards.ButtonType.*;
import static ru.sosweet.keyboards.ButtonType.MENU;

public class AboutKeyboard extends Keyboard {

    private static String about = null;
    private static final String aboutFilePath = "src/main/resources/text/about";

    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        LinkedHashMap<String, ButtonType> mainKeyboard = new LinkedHashMap<>();
        mainKeyboard.put("instagram", INST);
        return new SendMessage()
                .setChatId(chat_id)
                .setText(readAbout())
                .setReplyMarkup(setCustomKeyboard(mainKeyboard, true));
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return ButtonType.CAFE;
    }

    private static String readAbout() {

        if (about == null) {
            try {
                byte[] result = Files.readAllBytes(Paths.get(aboutFilePath));
                about = new String(result);
                return about;

            } catch (IOException ex) {
                //todo прикрутить логер
                ex.printStackTrace();
            }
        }
        return about;
    }

}
