package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String,String> bookingdatesMapMethod (String checkin , String checkout){

        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);

        return bookingdatesMap;
    }
    public  Map<String, Object> expecdetDataMapMethod(String firstname, String lastname,int totalprice, boolean depositpaid,Map<String,String> bookingdatesMap , String additionalneeds ){

        Map<String, Object> expecdetData = new HashMap<>();
        expecdetData.put("firstname",firstname);
        expecdetData.put("lastname",lastname);
        expecdetData.put("totalprice",totalprice);
        expecdetData.put("depositpaid",depositpaid);
        expecdetData.put("bookingdates",bookingdatesMap);

        if(additionalneeds!=null){
        expecdetData.put("additionalneeds",additionalneeds);
        }

        return expecdetData;
    }


}
/*


        = new HashMap<>();

 */