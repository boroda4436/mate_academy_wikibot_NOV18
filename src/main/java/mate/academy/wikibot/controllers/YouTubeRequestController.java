package mate.academy.wikibot.controllers;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.List;

import mate.academy.wikibot.dto.YouTubeRequestDto;

import org.springframework.stereotype.Controller;

@Controller
public class YouTubeRequestController {
    /**
     * This function does GET query and gets list of SearchResult.
     *
     * @param requestDto - object of YouTubeRequestDto.
     * @return list of SearchResult.
     */
    public List<SearchResult> getListOfVideo(YouTubeRequestDto requestDto) throws IOException {
        YouTube youTube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest httpRequest) throws IOException {

            }
        }).setApplicationName("app").build();

        YouTube.Search.List search = youTube.search().list("id,snippet");
        search.setKey(requestDto.getApiKey());
        search.setQ(requestDto.getQuery());
        search.setType("video");
        search.setFields("items(id/kind,id/videoId)");
        search.setMaxResults(Long.valueOf(requestDto.getMaxResults()));
        SearchListResponse searchResponse = search.execute();
        return searchResponse.getItems();
    }
}
