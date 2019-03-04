package mate.academy.wikibot.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String kind;
    private String videoId;
    private String title;
    private String url;
}
