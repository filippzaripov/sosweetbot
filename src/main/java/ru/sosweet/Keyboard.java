package ru.sosweet;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.sosweet.cakes.CakeType;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {

    public static ReplyKeyboardMarkup getMainKeyboard() {
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Кафе");
        row.add("Торты на заказ");
        keyboard.add(row);
        return new ReplyKeyboardMarkup().setKeyboard(keyboard);
    }

    public static ReplyKeyboardMarkup getCakes() {
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        for (CakeType type : CakeType.values()) {
            row.add(type.getDescription());
            keyboard.add(row);
            row = new KeyboardRow();
        }
        return new ReplyKeyboardMarkup().setKeyboard(keyboard);
    }

}
