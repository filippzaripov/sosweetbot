package ru.sosweet.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import static ru.sosweet.keyboards.ButtonType.CAFE;
import static ru.sosweet.keyboards.ButtonType.MAIN;

public abstract class Keyboard {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String text = "";

    InlineKeyboardMarkup setCustomKeyboard(LinkedHashMap<String, ButtonType> textAndCallback, boolean setURL) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        if (textAndCallback.size() > 0) {
            textAndCallback.forEach((text, callback) -> {
                InlineKeyboardButton button = new InlineKeyboardButton();
                if (setURL) {
                    button.setText(text)
                            .setUrl(callback.callBackData);
                } else {
                    button.setText(text)
                            .setCallbackData(callback.callBackData);
                }
                rowList.add(Collections.singletonList(button));
            });
        }
        if (!textAndCallback.containsValue(CAFE)) {
            rowList.add(getBackAndHomeInlineButtons(getPreviousKeyboardButton()));
        }
        markup.setKeyboard(rowList);
        return markup;
    }

    public InlineKeyboardMarkup getBackKeyboard(ButtonType prevButton) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(getBackAndHomeInlineButtons(prevButton));
        markup.setKeyboard(rowList);
        return markup;
    }

    public static List<InlineKeyboardButton> getBackAndHomeInlineButtons(ButtonType prevButton) {
        List<InlineKeyboardButton> rowList = new ArrayList<>();
        rowList.add(
                new InlineKeyboardButton()
                        .setText("Назад")
                        .setCallbackData(prevButton.callBackData));
        rowList.add(
                new InlineKeyboardButton()
                        .setText("В начало")
                        .setCallbackData(MAIN.callBackData));
        return rowList;
    }

    public abstract SendMessage getKeyboardSendMessage(long chat_id);

    public abstract ButtonType getPreviousKeyboardButton();

}
