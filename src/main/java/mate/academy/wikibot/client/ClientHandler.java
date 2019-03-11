package mate.academy.wikibot.client;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ClientHandler {
    private static HttpClient httpClient = getHttpClientInstance();

    private ClientHandler() {
    }

    /**
     * Singleton static method that returns single  httpClient object
     *
     * @return httpClient object
     */
    public static HttpClient getHttpClientInstance() {
        if (httpClient == null) {
            return HttpClientBuilder.create().build();
        } else {
            return httpClient;
        }
    }
}
