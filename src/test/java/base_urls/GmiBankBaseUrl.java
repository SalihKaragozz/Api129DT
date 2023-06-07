package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjg4NzYzNDQyfQ.e57FgixgN0rZbHGyi-B7xiXJcO1fpPhRmmVg58e8Szn4bAFf7cDh58PAwgykf35Cfk6j4oGkSTIqQT4Y7ngSYQ").setBaseUri("https://gmibank.com").build();
    }

}
