package ru.sosweet.factories;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.sosweet.keyboards.ButtonType;
import ru.sosweet.text.AboutTextMessage;
import ru.sosweet.text.TextMessage;

public class TextFactory {

    private static final TextMessage aboutText = new AboutTextMessage();

    //todo удалить в будущем если не понадобится
    public static TextMessage getMessage(ButtonType buttonType) {
        switch (buttonType) {
            case ABOUT:
                return aboutText;
            default:
                return new TextMessage() {
                    @Override
                    public SendMessage getMessage(long chat_id) {
                        return new SendMessage()
                                //todo добавить логер
                                .setText("Произошла неизвестная ошибка");
                    }

                    @Override
                    public ButtonType getPrevButton() {
                        return ButtonType.MAIN;
                    }
                };
        }
    }
}
