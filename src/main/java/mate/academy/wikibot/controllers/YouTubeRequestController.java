package mate.academy.wikibot.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.List;

import mate.academy.wikibot.dto.YouTubeRequestDto;
import mate.academy.wikibot.exception.MyException;
import mate.academy.wikibot.http.HttpClient;

import org.springframework.stereotype.Controller;

@Controller
public class YouTubeRequestController {
    /**
     * This function does GET query and gets list of SearchResult.
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
            String data = HttpClient.doGet(url);
            SearchListResponse youtubeVideoListResponse =
                    objectMapper.readValue(data, SearchListResponse.class);

            return youtubeVideoListResponse.getItems();
        } catch (IOException e) {
            throw new MyException(e);
        }
    }
}
