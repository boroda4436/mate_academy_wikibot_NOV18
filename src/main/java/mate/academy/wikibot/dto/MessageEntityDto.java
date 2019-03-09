package mate.academy.wikibot.dto;

import lombok.Data;

@Data
public class MessageEntityDto {
    private String type;
    private Integer offset;
    private Integer length;
    private String url;
}
