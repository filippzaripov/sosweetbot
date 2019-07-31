package ru.sosweet;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class CallbackQueryHandler {
    private static final Logger log = Logger.getLogger(CallbackQueryHandler.class);

    public static SendMessage replyQueryMain(Update update) {
        long chat_id = update.getCallbackQuery().getMessage().getChatId();
        switch (update.getCallbackQuery().getData()) {
            case "Торты на заказ":
                return SendMessageKeyboardFactory.cakeType(chat_id);
            case "Кафе":
                return SendMessageKeyboardFactory.cafe(chat_id);
            default:
                log.error("Нет обработчика на данный callbackQuery : " + update.getCallbackQuery().getMessage().getText());
                return SendMessageKeyboardFactory.errorMessage(chat_id);
        }

    }
}
