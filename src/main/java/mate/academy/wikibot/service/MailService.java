package mate.academy.wikibot.service;

import mate.academy.wikibot.dto.SendMailRequest;
import mate.academy.wikibot.dto.SendMailResponse;

public interface MailService {
    SendMailResponse sendMessage(SendMailRequest mailRequest) throws Exception;
}
