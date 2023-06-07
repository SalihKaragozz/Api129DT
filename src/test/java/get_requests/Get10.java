package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get10 extends GoRestBaseUrl {
       /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Gov. Vrinda Panicker", "Sen. Devika Embranthiri" and "Rev. Jay Shukla" are among the users
        And
            The female users are less than or equals to male users
            (Kadın kullanıcı sayısı erkek kullanıcı sayısından küçük yada eşit olamlı)
     */

    @Test
    public void get10() {
        //Set the url
        spec.pathParam("first", "users");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)
                .body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data", hasSize(10),
                        "data.status", hasItem("active"),
                        "data.name", hasItems("Baala Chopra", "Shubha Varma", "Kanti Naik"));

        //The female users are less than or equals to male users
        //Kadın ve erkek sayılarını karşılaştıralım:
        JsonPath jsonPath = response.jsonPath();
        List<String> genderList = jsonPath.getList("data.gender");
        System.out.println("genderList = " + genderList);

        int kadinSayisi = 0;
        for (String w : genderList) {
            if (w.equalsIgnoreCase("female")) {
                kadinSayisi++;
            }
        }

        System.out.println("kadinSayisi = " + kadinSayisi);
        assertTrue(kadinSayisi <= genderList.size() - kadinSayisi);

        //2. Yol Groovy:
        //Groovy kullanarak gender değeri "female" olan elemenları filtreliyoruz. Kadın sayısını buluyoruz.
        int kadinSayisiGroovy = jsonPath.getList("data.findAll{it.gender=='female'}").size();
        System.out.println("kadinSayisiGroovy = " + kadinSayisiGroovy);

        //Groovy kullanarak gender değeri "male" olan elemenları filtreliyoruz.
        int erkekSayisiGroovy = jsonPath.getList("data.findAll{it.gender=='male'}").size();
        assertTrue(kadinSayisiGroovy <= erkekSayisiGroovy);

    }
}
