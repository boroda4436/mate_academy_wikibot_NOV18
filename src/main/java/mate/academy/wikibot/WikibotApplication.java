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

        /*
         * Link on which the request is executed.
         */
//        String query = "https://www.googleapis.com/youtube/v3/videos";
        String query = "https://developers.google.com/youtube/v3/code_samples/java#search_by_keyword";

        /*
         * Method for executing request and receiving response.
         */
        System.out.println(RequestController.doRequest(query, "GET"));
    }
}
