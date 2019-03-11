package mate.academy.wikibot.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
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

public class YouTubeRequestController {
    /**
     * this function does GET query and gets HttpResponse
     * @param requestDto
     * @return list of YouTubeResponseDto
     */
    public static List<YouTubeResponseDto> getListOfVideo(YouTubeRequestDto requestDto) {
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


            return deserializeJson(data);
        } catch (IOException e) {
            throw new MyException(e);
        }
    }

    /**
     * this function deserialize json using Jackson library and Tree Model
     * @param data
     * @return list of YouTubeResponseDto
     */
    private static List<YouTubeResponseDto> deserializeJson(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<YouTubeResponseDto> responseDtos = new ArrayList<>();

        try {
            JsonNode rootNode = objectMapper.readTree(data);
            JsonNode items = rootNode.get("items");
            Iterator<JsonNode> iterator = items.elements();

            while (iterator.hasNext()) {
                JsonNode item = iterator.next();
                String videoId = item.get("id").get("videoId").toString();
                String title = item.get("snippet").get("title").toString();

                YouTubeResponseDto responseDto = new YouTubeResponseDto();
                responseDto.setVideoId(videoId);
                responseDto.setTitle(title);
                responseDtos.add(responseDto);
            }

            return responseDtos;
        } catch (IOException e) {
            throw new MyException(e);
        }
    }
}
