package mate.academy.wikibot.http;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientHandler {
    private static HttpClient httpClient = getHttpClient();

    private HttpClientHandler() {
    }

    public static HttpClient getHttpClient(){
        if(httpClient == null)
         return HttpClientBuilder.create().build();
        else return httpClient;
    }
}
