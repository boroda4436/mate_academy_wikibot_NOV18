package mate.academy.wikibot.service;

import mate.academy.wikibot.dto.input.SendMailRequest;
import mate.academy.wikibot.dto.output.SendMailResponse;

public interface MailService {
    SendMailResponse sendMessage(SendMailRequest mailRequest) throws Exception;
}
