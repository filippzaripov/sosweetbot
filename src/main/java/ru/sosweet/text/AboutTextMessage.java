package ru.sosweet.text;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.sosweet.keyboards.ButtonType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AboutTextMessage extends TextMessage {
    private static String about = null;
    private static final String aboutFilePath = "src/main/resources/text/about";


    @Override
   public SendMessage getMessage(long chat_id) {
        return new SendMessage()
                .setChatId(chat_id)
                .setText(readAbout());
    }

    @Override
   public ButtonType getPrevButton() {
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
