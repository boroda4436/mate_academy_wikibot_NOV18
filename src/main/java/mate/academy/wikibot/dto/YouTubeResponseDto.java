package mate.academy.wikibot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class YouTubeResponseDto {
    private String videoId;
    private String title;
}
