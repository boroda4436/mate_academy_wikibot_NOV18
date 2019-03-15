package mate.academy.wikibot.http;

import mate.academy.wikibot.exception.MyException;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;


@Component
public class HttpClient {

    private HttpClient() {
    }

    /**
     * Static method that does get query and gets string format of JSON.
     *
     * @return string format of JSON.
     */
    public static String doGet(String url) {
        try {
            org.apache.http.client.HttpClient client =
                    HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            HttpResponse httpResponse = client.execute(get);
            HttpEntity httpEntity = httpResponse.getEntity();
            String data = EntityUtils.toString(httpEntity);

            return data;
        } catch (IOException e) {
            throw new MyException(e);
        }
    }
}
