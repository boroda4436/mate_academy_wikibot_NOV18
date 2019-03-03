package mate.academy.wikibot.httpClient;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientHandler {
    private static HttpClient httpClientHandler = getInstance();

    private HttpClientHandler() {

    }

    public static HttpClient getInstance() {
        if (httpClientHandler == null) {
            return HttpClientBuilder.create().build();
        }
        else return httpClientHandler;
    }
}
