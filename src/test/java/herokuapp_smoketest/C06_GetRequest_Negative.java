package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C06_GetRequest_Negative extends HerOkuAppBaseUrl {
     /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Send get request
    Then
        Status code is 404
    And
        Body is "Not Found"
     */

    @Test
    public void get02(){
        //Set the url
        spec.pathParams("first","booking","second",bookingId);

        // set the expected data
        String expectedData = "Not Found";

        // send the request and get the response
      Response response = given(spec).get("{first}/{second}");
      response.prettyPrint();


        //Do assertion
        assertEquals(404, response.statusCode());
        assertEquals(expectedData, response.asString());





    }
}
