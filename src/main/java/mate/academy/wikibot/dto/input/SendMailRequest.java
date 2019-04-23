package mate.academy.wikibot.dto.input;

import lombok.Data;

@Data
public class SendMailRequest {
    private String sendTo;
    private String title;
    private String message;
}
