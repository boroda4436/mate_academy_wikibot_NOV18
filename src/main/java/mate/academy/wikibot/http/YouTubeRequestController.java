package mate.academy.wikibot.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import mate.academy.wikibot.client.ClientHandler;
import mate.academy.wikibot.dto.YouTubeRequestDto;
import mate.academy.wikibot.exception.MyException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class YouTubeRequestController {
    /**
     * This function does GET query and gets HttpResponse.
     *
     * @param requestDto - object of YouTubeRequestDto.
     * @return list of SearchResult.
     */
    public static List<SearchResult> getListOfVideo(YouTubeRequestDto requestDto) {
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
            HttpGet get = new HttpGet(url);
            HttpResponse httpResponse = client.execute(get);
            HttpEntity httpEntity = httpResponse.getEntity();
            String data = EntityUtils.toString(httpEntity);
            SearchListResponse youtubeVideoListResponse =
                    objectMapper.readValue(data, SearchListResponse.class);

            return youtubeVideoListResponse.getItems();
        } catch (IOException e) {
            throw new MyException(e);
        }
    }
}
