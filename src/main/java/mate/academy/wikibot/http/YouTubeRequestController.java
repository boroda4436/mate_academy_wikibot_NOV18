package mate.academy.wikibot.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mate.academy.wikibot.client.ClientHandler;
import mate.academy.wikibot.dto.YouTubeRequestDto;
import mate.academy.wikibot.dto.YouTubeResponseDto;
import mate.academy.wikibot.exception.MyException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YouTubeRequestController {
    /**
     * @param requestDto
     * @return
     */
    public static List<YouTubeResponseDto> getListOfVideo(YouTubeRequestDto requestDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        final String url = String.format("https://www.googleapis.com/youtube/v3/search?part=snippet"
                        + "&maxResults=%s"
                        + "&q=%s"
                        + "&topicId=%s"
                        + "&fields=items(id%%2FvideoId%%2Csnippet%%2Ftitle)"
                        + "&key=%s",
                requestDto.getMaxResults(),
                requestDto.getQuery(),
                requestDto.getTopicId(),
                requestDto.getApiKey());

        try {
            HttpClient client = ClientHandler.getHttpClientInstance();
            StringBuilder stringBuilder = new StringBuilder(url);
            HttpGet get = new HttpGet(stringBuilder.toString());
            HttpResponse httpResponse = client.execute(get);
            HttpEntity httpEntity = httpResponse.getEntity();
            String data = EntityUtils.toString(httpEntity);
            List<YouTubeResponseDto> videos = objectMapper.readValue(data,
                    new TypeReference<ArrayList<YouTubeResponseDto>>() {

                    });

            return videos;
        } catch (IOException e) {
            throw new MyException(e);
        }
    }

    /*private static String getApiKey() {
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
    }*/
}
