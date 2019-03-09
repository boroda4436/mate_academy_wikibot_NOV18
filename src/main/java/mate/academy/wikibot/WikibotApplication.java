package mate.academy.wikibot;

import mate.academy.wikibot.controllers.RequestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class for starting project.
 */
@SpringBootApplication
public class WikibotApplication {

    /**
     * Main method for starting project.
     */
    public static void main(String[] args) {
        SpringApplication.run(WikibotApplication.class, args);
    }
}
