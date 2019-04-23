package mate.academy.wikibot.service;

import mate.academy.wikibot.dto.input.SendMailRequest;
import mate.academy.wikibot.dto.output.SendMailResponse;
import mate.academy.wikibot.http.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Value("${mail.service.url}")
    private String mailServiceConnectionUrl;

    private final HttpClient httpClient;

    @Autowired
    public MailServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public SendMailResponse sendMessage(SendMailRequest mailRequest) throws Exception {
        return httpClient.send(mailServiceConnectionUrl, mailRequest, SendMailResponse.class);
    }
}
