package ru.sosweet;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.sosweet.factories.SendMessageKeyboardFactory;
import ru.sosweet.keyboards.ButtonType;
import ru.sosweet.photos.MenuPhotoReply;

import static ru.sosweet.keyboards.ButtonType.MAIN;
import static ru.sosweet.keyboards.ButtonType.MENU;

public class MainHandlerBot extends SoSweetBot {


    public void handle(Update update) throws TelegramApiException {
        if (update.hasMessage()) {
            Message updateMessage = update.getMessage();
            long chat_id = update.getMessage().getChatId();
            if (updateMessage.hasText()) {
                String message_text = update.getMessage().getText();

                if (message_text.equals("/start")) {
                    execute(SendMessageKeyboardFactory.getKeyboard(MAIN).getKeyboardSendMessage(chat_id));

                } else if (message_text.equals("/pic")) {
                    SendPhoto msg = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto("AgADAgAD3qoxGwluwEkGgisQumDD1T2ehQ8ABEbYNf20qqALvNMCAAEC")
                            .setCaption("Photo");
                    execute(msg); // Call method to send the photo

                } else if (message_text.equals("/test")) {
                    execute(SendMessageKeyboardFactory
                            .getKeyboard(MAIN)
                            .getKeyboardSendMessage(chat_id));
                } else if (message_text.equals("/menu")) {
                    MenuPhotoReply.getSendPhotos(chat_id).forEach(photo -> {
                        try {
                            execute(photo);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    });

                }
            }
        } else if (update.hasCallbackQuery()) {
            //todo выделить содержимое метода в другой метод
            String callBack = update.getCallbackQuery().getData();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            if (ButtonType.getButtonTypeByCallback(callBack) == MENU) {
                MenuPhotoReply.getSendPhotos(chat_id).forEach(photo -> {
                    try {
                        execute(photo);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                execute(CallbackQueryHandler.replyQuery(update));
            }
        }
    }
}
