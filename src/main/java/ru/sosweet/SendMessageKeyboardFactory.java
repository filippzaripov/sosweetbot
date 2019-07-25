package ru.sosweet;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class SendMessageKeyboardFactory {

    private static InlineKeyboardMarkup setCustomKeyboard(LinkedHashMap<String, String> textAndCallback) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        textAndCallback.forEach((text, callback) -> {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(text)
                    .setCallbackData(callback);
            rowList.add(Collections.singletonList(button));
            markup.setKeyboard(rowList);
        });
        return markup;
    }


    public static SendMessage mainKeyboard(long chat_id) {
        LinkedHashMap<String, String> mainKeyboard = new LinkedHashMap<>();
        mainKeyboard.put("Кафе", "Кафе");
        mainKeyboard.put("Торты на заказ", "Торты на заказ");
        return new SendMessage()
                .setChatId(chat_id)
                .setText("TEST")
                .setReplyMarkup(setCustomKeyboard(mainKeyboard));
    }

    public static SendMessage cakeType(long chat_id){
        LinkedHashMap<String, String> mainKeyboard = new LinkedHashMap<>();
        mainKeyboard.put("Торт", "Торт");
        mainKeyboard.put("Чизкейк", "Чизкейк");
        mainKeyboard.put("Десерт", "Десерт");
        return new SendMessage()
                .setChatId(chat_id)
                .setText("Выбери тип торта")
                .setReplyMarkup(setCustomKeyboard(mainKeyboard));
    }

    public static SendMessage cafe(long chat_id){
        LinkedHashMap<String, String> mainKeyboard = new LinkedHashMap<>();
        mainKeyboard.put("О нас", "О нас");
        mainKeyboard.put("Контакты", "Контакты");
        mainKeyboard.put("Акции", "Акции");
        return new SendMessage()
                .setChatId(chat_id)
                .setText("Жмакай, дружище!")
                .setReplyMarkup(setCustomKeyboard(mainKeyboard));
    }

    public static SendMessage errorMessage(long chat_id){
        return new SendMessage().setText("Произошла неизвестная ошибка");
    }

    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Тык");
        inlineKeyboardButton1.setCallbackData("Button \"Тык\" has been pressed");
        inlineKeyboardButton2.setText("Тык2");
        inlineKeyboardButton2.setCallbackData("Button \"Тык2\" has been pressed");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("Fi4a").setCallbackData("CallFi4a"));
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Пример").setReplyMarkup(inlineKeyboardMarkup);
    }


}
