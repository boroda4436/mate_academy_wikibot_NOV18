package mate.academy.wikibot.service;

import mate.academy.wikibot.dto.SendMailRequest;
import mate.academy.wikibot.http.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class is responsible for sending message.
 */
@Component
public class MailScheduler {
    @Autowired
    private HttpClient httpClient;

    /**
     * Method initialize MailRequest and send message.
     *
     * @return String with Response.
     */
    public String sendMessage() {
        SendMailRequest sendMailRequest = new SendMailRequest();
        sendMailRequest.setEmail("yat8kat@gmail.com");
        sendMailRequest.setTitle("Bot statistic");
        sendMailRequest.setMessage("Hello World Again and Again");
        String data1 = httpClient.doPost("http://localhost:8081/mail/send", sendMailRequest);
        return data1;
    }
}
