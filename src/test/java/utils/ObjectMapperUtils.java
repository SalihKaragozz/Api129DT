package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    //<T> T --> Herhangi bir data tipini temsil eder.
    //readValue() methodu birinci paramtrede aldığı String Json datayı ikinci paramterde belirtilen data tipine çevirir.
    public static <T> T convertJsonToJava(String json, Class<T> cls) {//Generic Method

        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}