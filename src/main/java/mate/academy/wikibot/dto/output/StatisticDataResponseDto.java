package mate.academy.wikibot.dto.output;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticDataResponseDto {
    private Long chatId;
    private List<String> requests;
}
