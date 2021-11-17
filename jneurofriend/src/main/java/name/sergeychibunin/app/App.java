package name.sergeychibunin.app;

import name.sergeychibunin.JNFBot.JNFBot
import org.telegram.telegrambots.meta.TelegramBotsApi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi();
            botsApi.registerBot(new JNFBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
