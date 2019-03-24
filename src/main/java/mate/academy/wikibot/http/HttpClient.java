package mate.academy.wikibot.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;

import lombok.extern.log4j.Log4j2;
import mate.academy.wikibot.util.BaseSerializer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class is responsible for making HTTP requests.
 */
@Log4j2
@Component
public class HttpClient {
    private static String CONTENT_TYPE_JSON = "application/json";

    private final BaseSerializer serializer;
    
    private org.apache.http.client.HttpClient client;
    private String contentType = CONTENT_TYPE_JSON;

    private Lock lock = new ReentrantLock();

    @Autowired
    public HttpClient(BaseSerializer serializer) {
        this.serializer = serializer;
    }

    @PostConstruct
    public void init() throws Exception {
        client = HttpClientBuilder.create().build();
    }

    private HttpResponse post(String connectionUrl, Object requestObj, String contentType)
            throws Exception {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        serializer.serialize(requestObj, outStream);

        HttpEntity entity = new ByteArrayEntity(outStream.toByteArray());

        HttpPost post = new HttpPost(connectionUrl);
        post.setHeader("Accept", "*");
        post.setHeader("Content-Type", contentType);
        post.setEntity(entity);

        return execute(post);
    }

    /**
     * Perform GET request.
     * @param requestObj the request object to be send
     * @param connectionUrl the URL to connect and execute request
     * @param respClass the class we are expecting to receive response
     * @param <T> the class we are expecting to receive response
     * @return the response of GET request
     * @throws Exception the IOException
     */
    public synchronized <T> T send(String connectionUrl, Object requestObj, Class<T> respClass)
            throws Exception {
        lock.lock();
        try {
            HttpResponse response = post(connectionUrl, requestObj, contentType);
            InputStream is = response.getEntity().getContent();

            T res = serializer.deserialize(respClass, is);
            is.close();
            return res;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Perform GET request and get String representation of response.
     * @param requestObj the request object to be send
     * @param connectionUrl the URL to connect and execute request
     * @return the response of GET request
     * @throws Exception the IOException
     */
    public synchronized String send(String connectionUrl, Object requestObj) throws Exception {
        lock.lock();
        try {
            HttpResponse response = post(connectionUrl, requestObj, "application/json");
            InputStream is = response.getEntity().getContent();
            String resp = IOUtils.toString(is, "UTF-8");
            is.close();
            return resp;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Perform GET request.
     * @param connectionUrl the URL to connect and execute request
     * @param respClass the class we are expecting to receive response
     * @param <T> the class we are expecting to receive response
     * @return the response of GET request
     * @throws Exception the IOException
     */
    public synchronized <T> T get(String connectionUrl, Class<T> respClass) throws Exception {
        lock.lock();
        try {

            HttpGet get = new HttpGet(connectionUrl);
            get.setHeader("Accept", "*");
            get.setHeader("Content-Type", contentType);

            HttpResponse response = execute(get);
            InputStream is = response.getEntity().getContent();

            T res = serializer.deserialize(respClass, is);
            is.close();
            return res;
        } finally {
            lock.unlock();
        }
    }

    private HttpResponse execute(HttpUriRequest request) throws Exception {
        HttpResponse response = null;
        int status = 0;
        try {
            response = client.execute(request);
            status = response.getStatusLine().getStatusCode();

        } catch (IOException e) {
            log.debug("Socket Exception. Trying to re-create");
            init();

            response = client.execute(request);
            status = response.getStatusLine().getStatusCode();

        }

        if (status != HttpsURLConnection.HTTP_OK) {
            EntityUtils.consume(response.getEntity());
            throw new RuntimeException("status: " + status);
        }

        return response;
    }
}
