package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
    /*
      Given
          https://restful-booker.herokuapp.com/booking/1170
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
   */

    @Test
    public void get09(){
        //Set the url
        spec.pathParams("first","booking","second",96);

        // set the expected data
        Map<String,String> bookingdatesMap = new HashMap<>();//önce inner Map oluşturulur
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String, Object> expecdetData = new HashMap<>();
        expecdetData.put("firstname","John");
        expecdetData.put("lastname","Smith");
        expecdetData.put("totalprice",111);
        expecdetData.put("depositpaid",true);
        expecdetData.put("bookingdates",bookingdatesMap);
        expecdetData.put("additionalneeds","Breakfast");
        System.out.println("expecdetData = " + expecdetData);

        // send the request and get the response
       Response response = given(spec).get("{first}/{second}");
       response.prettyPrint();

       //Do assertion
      Map<String, Object> actualData = response.as(HashMap.class);//Se-Serialization
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
       assertEquals(expecdetData.get("firstname"),actualData.get("firstname"));
       assertEquals(expecdetData.get("lastname"),actualData.get("lastname"));
       assertEquals(expecdetData.get("totalprice"),actualData.get("totalprice"));
       assertEquals(expecdetData.get("depositpaid"),actualData.get("depositpaid"));
        //Value olarak "Object" data tipi dönen değerleri Casting yaparak asıl data türüne çeviriyoruz ve methodlara bu yöntem ile ulaşabiliyoruz.

       assertEquals(  ((Map)expecdetData.get("bookingdates")).get("checkin") ,((Map)actualData.get("bookingdates")).get("checkin"));
       assertEquals(expecdetData.get("additionalneeds"),actualData.get("additionalneeds"));



    }

    @Test
    public void get09b(){// dinamik yöntem
        //Set the url
        spec.pathParams("first","booking","second",4237);

        // set the expected data
      HerOkuAppTestData obj =  new HerOkuAppTestData();
        Map<String,String> bookingdatesMap = obj.bookingdatesMapMethod("2018-01-01","2019-01-01");


        Map<String, Object> expecdetData =
                obj.expecdetDataMapMethod("John","Smith",111,true, bookingdatesMap,"Breakfast");

        System.out.println("expecdetData = " + expecdetData);

        // send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expecdetData.get("firstname"),actualData.get("firstname"));
        assertEquals(expecdetData.get("lastname"),actualData.get("lastname"));
        assertEquals(expecdetData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expecdetData.get("depositpaid"),actualData.get("depositpaid"));
        //Value olarak "Object" data tipi dönen değerleri Casting yaparak asıl data türüne çeviriyoruz ve methodlara bu yöntem ile ulaşabiliyoruz.

        assertEquals(  ((Map)expecdetData.get("bookingdates")).get("checkin") ,((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(expecdetData.get("additionalneeds"),actualData.get("additionalneeds"));



    }
}
