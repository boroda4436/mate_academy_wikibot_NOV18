package mate.academy.wikibot.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import mate.academy.wikibot.dto.SendMailRequest;
import mate.academy.wikibot.exception.MyException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

/**
 * Class is responsible for making HTTP requests.
 */
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
     * This function does POST query and gets string format of JSON.
     *
     * @param url             for sending requests.
     * @param sendMailRequest dto that describe request.
     * @return String.
     */
    //TODO: for testing mailsender service only
    public String doPost(String url, SendMailRequest sendMailRequest) {
        try {
            org.apache.http.client.HttpClient client =
                    HttpClientBuilder.create().build();
            ObjectMapper mapper = new ObjectMapper();
            String jsonFormatOfMailRequest = mapper.writeValueAsString(sendMailRequest);
            HttpPost post = new HttpPost(url);
            post.setEntity(new StringEntity(jsonFormatOfMailRequest,
                    ContentType.APPLICATION_JSON));
            HttpResponse httpResponse = client.execute(post);
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            throw new MyException(e);
        }
    }
}
