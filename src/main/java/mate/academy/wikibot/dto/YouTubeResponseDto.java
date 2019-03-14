package mate.academy.wikibot.dto;

import lombok.Data;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

@Data
public class YouTubeResponseDto {
    private String videoId;
    private String title;
    Integer [] var =  new Integer[1];

    Map map = new HashMap();
}
