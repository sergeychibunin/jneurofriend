package name.sergeychibunin.app;

import org.telegram.BotConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class JNFBot extends TelegramLongPollingBot {
    private final RSSTool twitter = new RSSTool();

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

                SendMessage message = askTwitterAccount();
                message.setChatId(update.getMessage().getChatId().toString());

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
       }
    }

    private SendMessage askTwitterAccount() {
        String tweet = twitter.get();
        SendMessage message = new SendMessage();
        message.setText(tweet);
        return message;
    }
}
