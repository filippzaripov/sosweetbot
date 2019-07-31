package ru.sosweet.photos;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class MenuPhotoReply extends PhotoReply {
    private static final File photo = new File("src/main/resources/img/menu1.jpeg");
    private static final File photo2 = new File("src/main/resources/img/menu2.jpeg");

    public static List<SendPhoto> getSendPhotos(long chat_id) {
        return Arrays.asList(
                new SendPhoto()
                        .setPhoto(photo)
                        .setChatId(chat_id),

                new SendPhoto()
                        .setPhoto(photo2)
                        .setChatId(chat_id));
    }

}
