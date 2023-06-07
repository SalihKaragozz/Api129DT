package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05_ObjectMapper_Map extends JsonPlaceHolderBaseUrl {
        /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }


            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post05() throws JsonProcessingException {
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data
        Map<String, Object> expectedData = new JsonPlaceHolderTestData().expectedDataMapMethod(55, "Tidy your room", false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        //ObjectMapper kullanarak response'ı Java objesine çeviriyoruz. readValue() methodu birinci paramtersinde okunacak datayı String olarak alır. İkinci paramtereye çevrilecek data tipi belirtilir.
        //import com.fasterxml.jackson.databind.ObjectMapper; --> new ObjectMapper()
        Map<String, Object> actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));


    }

}
