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

                } else if (message_text.equals("/test")) {
                    execute(SendMessageKeyboardFactory
                            .getKeyboard(MAIN)
                            .getKeyboardSendMessage(chat_id));
                }
            }
        } else if (update.hasCallbackQuery()) {
            String callBack = update.getCallbackQuery().getData();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            sendReply(callBack, chat_id);
        }
    }

    private void sendReply(String callback, long chat_id) throws TelegramApiException {

        switch (ButtonType.getButtonTypeByCallback(callback)) {
            case MENU:
                for (SendPhoto photo : CallbackQueryHandler.replyQueryPhoto(callback, chat_id)) {
                    execute(photo);
                }
                break;
            default:
                execute(CallbackQueryHandler.replyQueryKeyboard(callback, chat_id));
                break;
        }
    }
}
