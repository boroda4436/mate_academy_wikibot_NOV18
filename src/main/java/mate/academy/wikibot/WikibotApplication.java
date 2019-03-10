package mate.academy.wikibot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@ComponentScan("mate.academy")
public class WikibotApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(WikibotApplication.class, args);
    }
}
