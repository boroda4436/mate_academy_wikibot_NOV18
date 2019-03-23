package mate.academy.wikibot.service;

import mate.academy.wikibot.dto.SendMailRequest;
import mate.academy.wikibot.http.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {
    private final HttpClient httpClient;

    @Autowired
    public MailScheduler(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Send message. Please IMPLEMENT: add scheduler every week
     */
    public void sendMessage() {
        SendMailRequest sendMailRequest = new SendMailRequest();
        sendMailRequest.setSendTo("<add email here>");
        sendMailRequest.setTitle("Bot statistic");
        sendMailRequest.setMessage("Hello world");

        httpClient.doPost("http://localhost:8081/mail/send", sendMailRequest);
    }
}
