package mate.academy.wikibot.http;

import java.io.IOException;

import mate.academy.wikibot.exception.MyException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {
    /**
     * This function does get query and gets string format of JSON.
     *
     * @return string format of JSON.
     */
    public String doGet(String url) {
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

    /**
     * This function does get query and gets string format of JSON.
     *
     * @return string format of JSON.
     */
    public String doPost(String url, Object data) {
        try {
            org.apache.http.client.HttpClient client =
                    HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            HttpEntity request = new StringEntity("{\"sendTo\":\"boroda4436@gmail.com\", "
                    + "\"title\":\"Hello world\", \"message\":\"Clinton\"}");
            post.setEntity(request);
            post.setHeader("Content-Type", "application/json");
            HttpResponse httpResponse = client.execute(post);
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            throw new MyException(e);
        }
    }
}
