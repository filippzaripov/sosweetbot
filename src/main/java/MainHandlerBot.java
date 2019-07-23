import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainHandlerBot extends MyAmazingBot {

    public void handle(Update update) {
        if (update.hasMessage()) {


            Message updateMessage = update.getMessage();
            long chat_id = update.getMessage().getChatId();


            if (updateMessage.hasText()) {
                String message_text = update.getMessage().getText();

                if (message_text.equals("/start")) {
                    // User send /start
                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("Что тебе интересно?")
                            .setReplyMarkup(Keyboard.getMainKeyboard());
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (message_text.equals("/pic")) {
                    // User sent /pic
                    SendPhoto msg = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto("AgADAgAD3qoxGwluwEkGgisQumDD1T2ehQ8ABEbYNf20qqALvNMCAAEC")
                            .setCaption("Photo");
                    try {
                        execute(msg); // Call method to send the photo
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
