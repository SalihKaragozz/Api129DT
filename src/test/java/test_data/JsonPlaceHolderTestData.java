package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataMapMethod(Integer userId, String title, Boolean completed) {

        Map<String, Object> expectedData = new HashMap<>();
        if(userId != null){
            expectedData.put("userId", userId);
        }
        if(title!=null){
            expectedData.put("title", title);
        }
        if (completed != null){
            expectedData.put("completed", completed);
        }
        return expectedData;
    }

    //JsonPlaceHolder json datasını String'e çeviren method:
    public static String expectedDataInString(int userId, String title,boolean completed){

        return "{ \"userId\": "+userId+", \"title\": \""+title+"\", \"completed\": "+completed+" }";

    }
}

