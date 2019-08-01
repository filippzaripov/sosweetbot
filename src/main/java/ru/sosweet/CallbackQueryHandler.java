package ru.sosweet;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sosweet.factories.SendMessageKeyboardFactory;
import ru.sosweet.keyboards.ButtonType;
import ru.sosweet.photos.MenuPhotoReply;

import java.util.Collections;
import java.util.List;


class CallbackQueryHandler {
    private static final Logger log = Logger.getLogger(CallbackQueryHandler.class);

    static SendMessage replyQueryKeyboard(String callback, long chat_id) {
        return SendMessageKeyboardFactory
                .getKeyboard(ButtonType.getButtonTypeByCallback(callback))
                .getKeyboardSendMessage(chat_id);
    }

    static List<SendPhoto> replyQueryPhoto(String callback, long chat_id) {
        switch (ButtonType.getButtonTypeByCallback(callback)) {
            case MENU:
                return MenuPhotoReply.getSendPhotos(chat_id);
            default:
                return Collections.emptyList();
        }
    }
}
