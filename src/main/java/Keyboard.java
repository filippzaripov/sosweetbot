import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

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
}
