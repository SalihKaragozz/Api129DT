package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

public class C04_PatchRequest extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
        "totalprice": 111
        }
    When
        Send  patch request
    Then
        Status code is 200
    And
       Body:
        {
        "firstname" : "Ali",
        "lastname" : "Can",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
     */

    @Test
    public void patch01(){
        //Set the url





    }
}
