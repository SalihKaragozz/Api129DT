package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseUrl {
      /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos => toplam 200 todos olması gerekir
	    And
	        "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir
	    And
	        2, 7, and 9 should be among the userIds => userId değerleri arasında 2, 7 ve 9 bulunmalıdır
     */

    @Test
    public void get04() {
        //Set the url
        //String url = "https://jsonplaceholder.typicode.com/todos"; => Tavsiye edilmez
        spec.pathParam("first", "todos");// spec: tekrarlı işlemlerin konulduğu RequestSpecification objesi

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("", hasSize(200))//There should be 200 todos => toplam 200 todos olması gerekir
                .body("title", hasItem("quis eius est sint explicabo"))// "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir
                .body("userId", hasItems(2, 7, 9))// 2, 7, and 9 should be among the userIds => userId değerleri arasında 2, 7 ve 9 bulunmalıdır
        ;

        //hasSize() ==> Eleman sayısını assert eder
        //hasItem() ==> contains() methodu gibi bir objenin içerilip içerilmediğini assert eder --> import static org.hamcrest.CoreMatchers.hasItems;
        //hasItems() ==> containsAll() methodu gibi birden fazla objenin içerilip içerilmediğini assert eder

    }
}
