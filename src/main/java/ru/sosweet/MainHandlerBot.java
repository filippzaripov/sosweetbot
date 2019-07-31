package ru.sosweet;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainHandlerBot extends SoSweetBot {

    SendMessageKeyboardFactory messagesKeyboards = new SendMessageKeyboardFactory();


    public void handle(Update update) throws TelegramApiException {
        if (update.hasMessage()) {
            Message updateMessage = update.getMessage();
            long chat_id = update.getMessage().getChatId();
            if (updateMessage.hasText()) {
                String message_text = update.getMessage().getText();

                if (message_text.equals("/start")) {
                    execute(SendMessageKeyboardFactory.mainKeyboard(chat_id));
                } else if (message_text.equals("/pic")) {
                    SendPhoto msg = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto("AgADAgAD3qoxGwluwEkGgisQumDD1T2ehQ8ABEbYNf20qqALvNMCAAEC")
                            .setCaption("Photo");
                    execute(msg); // Call method to send the photo

                } else if (message_text.equals("Торты на заказ")) {

                } else if (message_text.equals("/test")) {
                    execute(SendMessageKeyboardFactory.mainKeyboard(chat_id));
                }
            }
        } else if (update.hasCallbackQuery()) {
            execute(CallbackQueryHandler.replyQueryMain(update));
        }
    }
}
