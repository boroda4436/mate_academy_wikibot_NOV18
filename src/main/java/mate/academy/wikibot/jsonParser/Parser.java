package mate.academy.wikibot.jsonParser;

import mate.academy.wikibot.MyException;
import mate.academy.wikibot.httpClient.ClientHandler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Parser {

    public static JSONArray getVideoJSON(String q, String topicId) {
        final String API_KEY = getApiKey();
        final String URL = String.format("https://www.googleapis.com/youtube/v3/search?part=snippet" +
                "&maxResults=25" +
                "&q=%s" +
                "&topicId=%s" +
                "&fields=items(id%%2FvideoId%%2Csnippet%%2Ftitle)" +
                "&key=%s", q, topicId, API_KEY);

        try {
            HttpClient client = ClientHandler.getHttpClientInstance();
            StringBuilder url = new StringBuilder(URL);
            HttpGet get = new HttpGet(url.toString());
            HttpResponse r = client.execute(get);
            HttpEntity e = r.getEntity();
            String data = EntityUtils.toString(e);
            JSONObject video = new JSONObject(data);
            JSONArray jsonArray = video.getJSONArray("items");

            return jsonArray;
        } catch (IOException | JSONException e) {
            throw new MyException(e);
        }
    }

    private static String getApiKey() {
        FileInputStream fileInputStream;
        Properties property = new Properties();

        try {
            fileInputStream = new FileInputStream("src/main/resources/youtube.properties");
            property.load(fileInputStream);
            String apiKey = property.getProperty("youtube.apikey");

            return apiKey;
        } catch (IOException e) {
            throw new MyException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(Parser.getVideoJSON("avatar","1"));
    }
}
