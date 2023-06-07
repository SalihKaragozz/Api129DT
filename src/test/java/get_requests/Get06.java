package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {

        /*
       Given
           https://restful-booker.herokuapp.com/booking/23
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
                {
                   "firstname": "Josh",
                   "lastname": "Allen",
                   "totalprice": 111,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2018-01-01",
                       "checkout": "2019-01-01"
                   },
                   "additionalneeds": "super bowls"
                }
     */

    @Test
    public void get06() {
        //Set the url
        spec.pathParams("first", "booking", "second", 27);

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        //1. Yol:
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("superb owls"));

        //2. Yol: Json Path
        JsonPath jsonPath = response.jsonPath();//jsonPath() methodu ile response'ı JsonPath objesine çevirdik

        assertEquals("Josh", jsonPath.getString("firstname"));
        assertEquals("Allen", jsonPath.getString("lastname"));
        assertEquals(111, jsonPath.getInt("totalprice"));
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
        assertEquals("superb owls", jsonPath.getString("additionalneeds"));

        //3. Yol: Test NG Soft Assertion

        //Soft assert adımları:
        //1. Soft assert objesi oluştur
        SoftAssert softAssert = new SoftAssert();

        //2. Assert yap
        softAssert.assertEquals(jsonPath.getString("firstname"), "Josh", "firstname uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("lastname"), "Allen", "lastname uyuşmadı");
        softAssert.assertEquals(jsonPath.getInt("totalprice"), 111, "totalprice uyuşmadı");
        softAssert.assertTrue(jsonPath.getBoolean("depositpaid"), "depositpaid uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"), "2018-01-01", "checkin uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"), "2019-01-01", "checkout uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"), "superb owls", "checkout uyuşmadı");


        //3. assertAll() methodunu kullan
        softAssert.assertAll();

    }

}
