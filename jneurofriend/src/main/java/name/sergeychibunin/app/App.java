package name.sergeychibunin.app;

import twitter4j.conf.ConfigurationBuilder;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("your consumer key")
                    .setOAuthConsumerSecret("your consumer secret")
                    .setOAuthAccessToken("your access token")
                    .setOAuthAccessTokenSecret("your access token secret");
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            TelegramLongPollingBot theBot = new JNFBot();
            theBot.setTwitter(twitter);
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(theBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
