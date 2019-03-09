package mate.academy.wikibot;

import mate.academy.bot.BotConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "mate.academy")
@SpringBootApplication
public class WikibotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikibotApplication.class, args);
    }
}
