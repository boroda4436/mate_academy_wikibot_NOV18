package mate.academy.wikibot.service;

import mate.academy.wikibot.dto.SendMailRequest;
import mate.academy.wikibot.dto.SendMailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StatisticMailScheduler {
    private final MailService mailService;

    @Autowired
    public StatisticMailScheduler(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * Send message. Please IMPLEMENT: add scheduler every week
     */
    public SendMailResponse sendMessage() throws Exception {
        SendMailRequest sendMailRequest = new SendMailRequest();
        sendMailRequest.setSendTo("<add email here>");
        sendMailRequest.setTitle("Bot statistic");
        sendMailRequest.setMessage("Hello world");
        return mailService.sendMessage(sendMailRequest);
    }
}
