package mate.academy.wikibot.dto;

import lombok.Data;

@Data
public class MessageDto {
    private Integer message_id;
    private Integer date;
    private ChatDto chat;
    private MessageEntityDto[] entities;
    private String text;
}
