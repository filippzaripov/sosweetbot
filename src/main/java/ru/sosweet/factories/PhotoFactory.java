package ru.sosweet.factories;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import ru.sosweet.keyboards.ButtonType;
import ru.sosweet.photos.MenuPhotoReply;

import java.util.Collections;
import java.util.List;

public class PhotoFactory {

    public static List<SendPhoto> getPhoto(ButtonType callBack, long chat_id) {
        switch (callBack) {
            case MENU:
                return MenuPhotoReply.getSendPhotos(chat_id);
            default:
                return Collections.emptyList();
        }
    }

}
