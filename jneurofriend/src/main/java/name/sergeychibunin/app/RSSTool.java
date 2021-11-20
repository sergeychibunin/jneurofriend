package name.sergeychibunin.app;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class RSSTool {
    public static final String FEED_URL = "https://rss.app/feeds/yUWI5hHnzqolvQ2P.xml";

    public String get() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(FEED_URL);
            doc.getDocumentElement().normalize();

            ArrayList<String> tweets = new ArrayList<>();
            String tweet;
            NodeList list = doc.getElementsByTagName("item");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    tweet = element.getElementsByTagName("title").item(0).getTextContent();
                    tweets.add(tweet);
                }
            }

            int maxTweetIndex = tweets.toArray().length - 1;
            int randomTweetIndex = (int) (Math.random() * maxTweetIndex);
            tweet = tweets.get(randomTweetIndex);
            return tweet;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new RSSTool().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}