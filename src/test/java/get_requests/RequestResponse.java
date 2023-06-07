package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    1) Postman manual test için kullanılır
    2) API otomasyonu için Rest-Assured Library kullanıyoruz
    3) Otomasyon kodlarının yazımı için şu adımların izlenmesi gerekir:
        a) Gereksinimleri anlama
        b) Test Case'i yazma:
            -Test yazmak için 'Gherkin Language' kullanıyoruz.
            x) Given: Ön koşullar --> Enpoint, Body ...
            y) When: Yapılacak işlemler --> Get, Put, Delete ...
            z) Then: Dönütler --> Assertion, Close ...
            t) And:  Art arda kullanılan aynı işlemler için and kullanılır
        c) Otomasyon kolarının yazma:
            i) Set the URL --> Endpoint'i kur
            ii) Set the expected data --> Beklenen veriyi kur
            iii) Send the request and get the response --> Request yolla, response al
            iv) Do Assertion --> Doğrulama yap
     */

    public static void main(String[] args) {

        //Get request nasıl yapılır:
        String endPoint = "https://petstore.swagger.io/v2/pet/9829946";
        Response response = given().get(endPoint);//io.restassured.RestAssured.given;
        //response.prettyPrint();//prettyPrint() methodu response'ı consola yazdırır

        //Status code nasıl yazdırılır:
        System.out.println("Status Code: "+response.statusCode());

        //Content Type nasıl yazdırılır:
        System.out.println("Content Type: "+response.contentType());

        //Status Line nasıl yazdırılır:
        System.out.println("Status Line: "+response.statusLine());

        //Header nasıl yazdırılır:
        System.out.println(response.header("Server"));
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Access-Control-Allow-Methods"));
        System.out.println(response.header("Date"));

        //Headers nasıl yazdırılır:
        System.out.println("------");
        System.out.println(response.headers());

        //Time nasıl yazdırılır:
        System.out.println("\nTime: "+response.getTime());


    }
}
