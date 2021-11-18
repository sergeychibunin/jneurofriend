package name.sergeychibunin.app;

import org.telegram.BotConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class JNFBot extends TelegramLongPollingBot {

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    public String getBotUsername() {
        return BotConfig.JNF_USER;
    }

    @Override
    public String getBotToken() {
        return BotConfig.JNF_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String gottenMessageBody = update.getMessage().getText();

            if (gottenMessageBody.startsWith("@jneurofriendbot")) {

                SendMessage message = new SendMessage();
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText(update.getMessage().getText());

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
       }
    }

    private SendMessage askTwitterAccount() {

    }
}
