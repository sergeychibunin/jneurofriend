package name.sergeychibunin.app;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App
{
    public static void main( String[] args )
    {
        try {
            TelegramLongPollingBot theBot = new JNFBot();
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(theBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
