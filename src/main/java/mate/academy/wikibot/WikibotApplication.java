package mate.academy.wikibot;

import mate.academy.wikibot.controllers.RequestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikibotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikibotApplication.class, args);

        String query = "http://www.google.com.ua";

        System.out.println(RequestController.doRequest(query, "GET"));
    }
}
