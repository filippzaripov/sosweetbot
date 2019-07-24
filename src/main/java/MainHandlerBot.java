import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MainHandlerBot extends SoSweetBot {


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

    public void handle(Update update) throws TelegramApiException {
        if (update.hasMessage()) {


            Message updateMessage = update.getMessage();
            long chat_id = update.getMessage().getChatId();


            if (updateMessage.hasText()) {
                String message_text = update.getMessage().getText();

                if (message_text.equals("/start")) {
                    // User send /start
                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("Что тебе интересно?")
                            .setReplyMarkup(Keyboard.getMainKeyboard());
                    execute(message); // Sending our message object to user
                } else if (message_text.equals("/pic")) {
                    // User sent /pic
                    SendPhoto msg = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto("AgADAgAD3qoxGwluwEkGgisQumDD1T2ehQ8ABEbYNf20qqALvNMCAAEC")
                            .setCaption("Photo");
                    execute(msg); // Call method to send the photo

                } else if (message_text.equals("Торты на заказ")) {
                    SendMessage message = new SendMessage()
                            .setChatId(chat_id)
                            .setText("Пожалуйста выбери тип торта")
                            .setReplyMarkup(Keyboard.getCakes());
                    execute(message);

                } else if (message_text.equals("/test")) {
                    execute(sendInlineKeyBoardMessage(chat_id));
                }
            }
        }
    }
}
