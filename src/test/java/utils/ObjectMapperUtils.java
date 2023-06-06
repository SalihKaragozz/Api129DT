package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.Map;

//<T> T --> Herhangi bir data tipini temsil eder.
//readValue() methodu birinci paramtrede aldığı String Json datayı ikinci paramterde belirtilen data tipine çevirir.
public class ObjectMapperUtils {
    public static <T> T convertJsonToJava( String json, Class<T> cls){//generic method

        try {
            return   new ObjectMapper().readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



}
