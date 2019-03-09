package mate.academy.wikibot.controllers;

import java.io.IOException;
import java.util.InputMismatchException;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Class for sending request and receiving response.
 *
 * @author Anatolii Levitskii
 */
public class RequestController {

    /**
     * Method for sending request and receiving response.
     */
    public static HttpResponse doRequest(String api, String requestMethod) {

        HttpUriRequest request =
                (HttpUriRequest) RequestController.findOutRequestMethod(requestMethod, api);
        HttpResponse response = null;

        try (
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse resp = client.execute(request)
        ) {
            response = resp;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    static HttpRequest findOutRequestMethod(String request, String api) {

        HttpRequest requestReturn = null;

        try {
            switch (request) {
                case ("GET"):
                    requestReturn = new HttpGet(api);
                    break;

                case ("POST"):
                    requestReturn = new HttpPost(api);
                    break;

                default:
                    throw new IllegalArgumentException("Wrong request method name: " + request);
            }
        } catch (InputMismatchException ime) {
            System.out.println("You input wrong request method: " + request);
        }

        if (requestReturn == null) {
            throw new IllegalArgumentException("You input wrong request method: " + request);
        }

        return requestReturn;
    }
}
