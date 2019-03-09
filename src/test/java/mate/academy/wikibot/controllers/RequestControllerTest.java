package mate.academy.wikibot.controllers;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestControllerTest {

    String api = "https://developers.google.com/youtube/v3/code_samples/java#search_by_keyword";
    HttpRequest actualRequest;
    String expectedResponseGet = "HttpResponseProxy{HTTP/1.1 200 OK";

    @Before
    public void autualRequestValue() {
        actualRequest = null;
    }

    @Test
    public void doRequestGet() {
        String actualResponseGet = RequestController.doRequest(api, "GET").toString().substring(0, 33);

        Assert.assertEquals(expectedResponseGet, actualResponseGet);
    }

    @Test
    public void findOutRequestMethodGet() {
        HttpRequest expectedRequestGet = new HttpGet(api);

        actualRequest = RequestController.findOutRequestMethod("GET", api);

        String expectedRequestForTest = String.valueOf(expectedRequestGet);
        String actualRequestForTest = String.valueOf(actualRequest);

        Assert.assertEquals(expectedRequestForTest, actualRequestForTest);
    }

    @Test
    public void findOutRequestMethodPost() {
        HttpRequest expectedRequesPost = new HttpPost(api);

        actualRequest = RequestController.findOutRequestMethod("POST", api);

        String expectedRequestForTest = String.valueOf(expectedRequesPost);
        String actualRequestForTest = String.valueOf(actualRequest);

        Assert.assertEquals(expectedRequestForTest, actualRequestForTest);
    }

    @Test
    public void findOutRequestMethodWrong() throws IllegalArgumentException {

        try {
            RequestController.findOutRequestMethod("WRONG", api);
            Assert.fail("You input wrong request method: " + "WRONG");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("You input wrong request method: WRONG",
                    e.getMessage());
        }
    }
}