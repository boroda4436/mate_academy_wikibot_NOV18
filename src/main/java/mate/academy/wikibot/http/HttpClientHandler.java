package mate.academy.wikibot.http;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Singleton for obtaining httpClient object.
 */
public class HttpClientHandler {
    private static HttpClient httpClient = getHttpClient();

    private HttpClientHandler() {
    }

    /**
     * method return single httpClient object.
     *
     * @return org.apache.http.client.HttpClient object.
     */
    public static HttpClient getHttpClient() {
        if (httpClient == null) {
            return HttpClientBuilder.create().build();
        } else {
            return httpClient;
        }
    }
}
