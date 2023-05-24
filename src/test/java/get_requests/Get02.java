package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.*;

public class Get02 {
         /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02() {
        //Set the url
        String url = "https://restful-booker.herokuapp.com/booking/0";

        //Set the expected data

        //Send the request and get the response
      Response response = given().get(url);
      response.prettyPrint();

        //Do assertion
        response.then().statusCode(404) //Status Line should be HTTP/1.1 404 Not Found
                        .statusLine("HTTP/1.1 404 Not Found"); //Status Line should be HTTP/1.1 404 Not Found



      //  Response body contains "Not Found"
        assertTrue(response.asString().contains("Not Found"));// toString() kullanmayınız

      //  Response body does not contain "TechProEd"
        assertFalse(response.asString().contains("TechProEd"));

      // Server is "Cowboy"
     String server = response.header("Server");
     assertEquals("Cowboy", server);


    }
}
