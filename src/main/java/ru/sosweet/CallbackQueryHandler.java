package ru.sosweet;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVenue;
import ru.sosweet.factories.SendMessageKeyboardFactory;
import ru.sosweet.keyboards.ButtonType;
import ru.sosweet.photos.MenuPhotoReply;

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

    static SendVenue replyQueryVenue(ButtonType callback, long chat_id) {
        switch (callback) {
            case LOCATION:
                return new SendVenue()
                        .setTitle("Кафе-Кондитерская SoSweet")
                        .setAddress("Б. Красная, 13, Казань, Татарстан")
                        .setLatitude((float) 55.7980573)
                        .setLongitude((float) 49.1182164)
                        .setChatId(chat_id);
            default:
                return null;
        }
    }
}
