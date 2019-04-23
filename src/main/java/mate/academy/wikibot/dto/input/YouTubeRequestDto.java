package mate.academy.wikibot.dto.input;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class YouTubeRequestDto {
    private Integer maxResults;
    private String query;
    private String apiKey;
    private String topicId;
}
