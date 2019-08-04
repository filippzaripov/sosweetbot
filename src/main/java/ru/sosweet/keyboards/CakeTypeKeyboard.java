package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import static ru.sosweet.keyboards.ButtonType.*;

public class CakeTypeKeyboard extends Keyboard {
    @Override
    public SendMessage getKeyboardSendMessage(long chat_id) {
        String text = "Приветствую дорогой гость!\n" +
                "Здесь ты можешь заказать кондитерское изделие на свой вкус.\n" +
                "Пожалуйста, выбери, что именно ты хочешь?\n\n" +
                "ВНИМАНИЕ! Ближайшая дата выполнения заказа : " +
                LocalDate.now().plusDays(3).format(formatter);
        LinkedHashMap<String, ButtonType> mainKeyboard = new LinkedHashMap<>();
        mainKeyboard.put("Торт", CAKE);
        mainKeyboard.put("Чизкейк", CHEESECAKE);
        mainKeyboard.put("Десерт", DESSERT);
        return new SendMessage()
                .setChatId(chat_id)
                .setText(text)
                .setReplyMarkup(setCustomKeyboard(mainKeyboard,false));
    }

    @Override
    public ButtonType getPreviousKeyboardButton() {
        return MAIN;
    }
}
