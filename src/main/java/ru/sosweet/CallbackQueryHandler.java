package ru.sosweet;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sosweet.factories.SendMessageKeyboardFactory;
import ru.sosweet.factories.TextFactory;
import ru.sosweet.keyboards.ButtonType;
import ru.sosweet.photos.MenuPhotoReply;
import ru.sosweet.text.TextMessage;

import java.util.Collections;
import java.util.List;


class CallbackQueryHandler {
    private static final Logger log = Logger.getLogger(CallbackQueryHandler.class);

    static SendMessage replyQueryKeyboard(ButtonType callback, long chat_id) {
        return SendMessageKeyboardFactory
                .getKeyboard(callback)
                .getKeyboardSendMessage(chat_id);
    }

    static List<SendPhoto> replyQueryPhoto(ButtonType callback, long chat_id) {
        switch (callback) {
            //todo make factory
            case MENU:
                return MenuPhotoReply.getSendPhotos(chat_id);
            default:
                return Collections.emptyList();
        }
    }

    static Pair<SendMessage, ButtonType> replyQueryText(ButtonType callback, long chat_id) {
        TextMessage message = TextFactory.getMessage(callback);
        switch (callback) {
            case ABOUT:
                return Pair.of(message
                        .getMessage(chat_id), message.getPrevButton());
            default:
                return Pair.of(TextFactory
                        .getMessage(ButtonType.ERROR)
                        .getMessage(chat_id), ButtonType.MAIN);
        }

    }

    static SendMessage replyBackKeyboard(ButtonType prevButton, long chat_id) {
        return SendMessageKeyboardFactory
                .getBackKeyboard(prevButton)
                .getKeyboardSendMessage(chat_id);
    }
}
