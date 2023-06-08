package gmi_bank;

import base_urls.GmiBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.State;
import utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostCountry extends GmiBankBaseUrl {
    /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
          "name": "Banana",
          "states": [
            {
              "id": 0,
              "name": "Apple"
            },
            {
              "id": 1,
              "name": "Orange"
            },
                {
              "id": 2,
              "name": "Pear"
            }
          ]
        }

      When
        Send post request
      Then
        Status code is 201
      And
        Body:
        {
            "id": 187487,
            "name": "Banana",
            "states": [
                {
                    "id": 1,
                    "name": "Apple",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Orange",
                    "tpcountry": null
                },
                {
                    "id": 3,
                    "name": "Pear",
                    "tpcountry": null
                }
            ]
        }

     */

    @Test
    public void post01() {
        //Set the url
        spec.pathParams("first", "api", "second", "tp-countries");

        //Set the expected data
        State state1 = new State(1, "Apple");
        State state2 = new State(2, "Orange");
        State state3 = new State(3, "Pear");
        List<State> stateList = new ArrayList<>();
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);

        Country expectedData = new Country("Banana", stateList);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
      Country actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Country.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(state1.getName(), actualData.getStates().get(0).getName());
        assertEquals(state1.getId(), actualData.getStates().get(0).getId());
        assertEquals(state2.getName(), actualData.getStates().get(1).getName());
        assertEquals(state2.getId(), actualData.getStates().get(1).getId());
        assertEquals(state3.getName(), actualData.getStates().get(2).getName());
        assertEquals(state3.getId(), actualData.getStates().get(2).getId());


    }
}