package mate.academy.wikibot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class YouTubeRequestDto {
    /**
     * Specifies the max result of returned video.
     */
    private Integer maxResults;
    /**
     * q - is the parameter of a query to youtube api.
     */
    private String query;
    private String apiKey;
    private String topicId;
}
