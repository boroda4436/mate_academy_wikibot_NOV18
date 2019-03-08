package mate.academy.wikibot.httpClient;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ClientHandler {
    private static HttpClient httpClient = getHttpClient();

    private ClientHandler() {
    }

    public static HttpClient getHttpClient(){
        if(httpClient == null)
         return HttpClientBuilder.create().build();
        else return httpClient;
    }
}
