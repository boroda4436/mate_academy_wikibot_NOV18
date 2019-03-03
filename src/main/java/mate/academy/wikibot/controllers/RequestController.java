package mate.academy.wikibot.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class for sending request and receiving response.
 *
 * @author Anatolii Levitskii
 * @version 1.0
 */
public class RequestController {

    /**
     * Method for sending request and receiving response.
     */
    public static String doRequest(String link, String requestMethod) {

        HttpURLConnection connection = null;
        String responseMessage = null;

        try {
            connection = (HttpURLConnection) new URL(link).openConnection();

            connection.setRequestMethod(requestMethod);
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                responseMessage = "Status: " + connection.getResponseCode() + ". Congradulation!!!";
            } else {
                responseMessage = "Failed. RECEIVE RESPONSE CODE:" + connection.getResponseCode()
                        + ". RESPONSE MESSAGE: " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return responseMessage;
    }
}
