package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object> expectedDataMapMethod(int userId, String title, boolean completed){

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",userId);
        expectedData.put("title",title);
        expectedData.put("completed",completed);

        return expectedData;
    }

}


