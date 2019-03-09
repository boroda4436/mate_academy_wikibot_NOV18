package mate.academy.wikibot.dto;

import lombok.Data;

/**
 * Class performs convertion from ResponseDto to MessageEntityDto.
 */
@Data
public class ResponseConverter {

    public MessageEntityDto convertToMessage(ResponseDto responseDto) {
        MessageEntityDto messageEntityDto = new MessageEntityDto();
        messageEntityDto.setUrl(responseDto.getVideoId());
        messageEntityDto.setType("url");
        messageEntityDto.setLength(responseDto.getVideoId().length());
        return messageEntityDto;
    }
}
