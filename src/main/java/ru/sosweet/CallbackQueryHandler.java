package ru.sosweet;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sosweet.factories.SendMessageKeyboardFactory;
import ru.sosweet.keyboards.ButtonType;


public class CallbackQueryHandler {
    private static final Logger log = Logger.getLogger(CallbackQueryHandler.class);

    public static SendMessage replyQuery(Update update) {
        long chat_id = update.getCallbackQuery().getMessage().getChatId();
        return SendMessageKeyboardFactory
                .getKeyboard(ButtonType.getButtonTypeByCallback(update
                        .getCallbackQuery()
                        .getData()))
                .getKeyboardSendMessage(chat_id);
    }
}
