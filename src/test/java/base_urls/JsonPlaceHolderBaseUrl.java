package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    //SetUp methodu ile tekrarlı yapılacak işlemleri topluyoruz. Ve test öncesi çalışacak şekilde @Before anatasyonu ekliyoruz.

    protected RequestSpecification spec;

    @Before//Her @Test methodu öncesi çalışır
    public void setUp(){

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com/").build();

    }

}
