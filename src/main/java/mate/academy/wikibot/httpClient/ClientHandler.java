package mate.academy.wikibot.httpClient;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ClientHandler {
    private static HttpClient httpClient = getHttpClientInstance();

    private ClientHandler() {
    }

    public static HttpClient getHttpClientInstance() {
        if (httpClient == null)
            return HttpClientBuilder.create().build();
        else {
            return httpClient;
        }
    }
}
