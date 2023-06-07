package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

        /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json"
        And
            Status Line should be "HTTP/1.1 200 OK"
     */

    @Test
    public void get01() {

        //1) Set the URl
        String url = "https://restful-booker.herokuapp.com/booking/55";

        //2) Set the expected data --> Bu kısım post ve put gibi body gerektiren ileriki testlerde yapılacak

        //3) Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

        //4) Do assertion
        response.then()//then() methodu ile response'ı doğrula
                .statusCode(200)//HTTP Status Code should be 200
                .contentType("application/json")//Content Type should be "application/json"
                .statusLine("HTTP/1.1 200 OK");//Status Line should be "HTTP/1.1 200 OK"

    }

}
