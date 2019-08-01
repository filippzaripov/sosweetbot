package ru.sosweet.text;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.sosweet.keyboards.ButtonType;

public abstract class TextMessage {

   public abstract SendMessage getMessage(long chat_id);

   public abstract ButtonType getPrevButton();
}
