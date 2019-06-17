package mate.academy.wikibot.dto.input;

import lombok.Data;

@Data
public class YouTubeRequestDto {
    private Integer maxResults;
    private String query;
    private String apiKey;
    private String topicId;
}
