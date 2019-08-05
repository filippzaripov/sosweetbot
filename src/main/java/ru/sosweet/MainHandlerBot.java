package ru.sosweet;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.sosweet.factories.SendMessageKeyboardFactory;
import ru.sosweet.keyboards.ButtonType;

import static ru.sosweet.keyboards.ButtonType.*;

public class MainHandlerBot extends SoSweetBot {


    public void handle(Update update) throws TelegramApiException {
        if (update.hasMessage()) {
            Message updateMessage = update.getMessage();
            long chat_id = update.getMessage().getChatId();
            if (updateMessage.hasText()) {
                String message_text = update.getMessage().getText();

                if (message_text.equals("/start")) {
                    execute(SendMessageKeyboardFactory.getKeyboard(MAIN).getKeyboardSendMessage(chat_id));

                } else if (message_text.equals("/test")) {
                    //for tests
                }
            }
        } else if (update.hasCallbackQuery()) {
            String callBack = update.getCallbackQuery().getData();
            System.out.println(callBack);
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            sendReply(ButtonType.getButtonTypeByCallback(callBack), chat_id);
        }
    }

    private void sendReply(ButtonType callback, long chat_id) throws TelegramApiException {
        switch (callback) {
            case MENU:
                for (SendPhoto photo : CallbackQueryHandler.replyQueryPhoto(callback, chat_id)) {
                    execute(photo);
                }
                execute(CallbackQueryHandler.replyQueryKeyboard(CAFE, chat_id));
                break;
            case LOCATION:
                execute(CallbackQueryHandler.replyQueryVenue(LOCATION, chat_id));
                break;
            default:
                execute(CallbackQueryHandler.replyQueryKeyboard(callback, chat_id));
                break;
        }
    }
}
