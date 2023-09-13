package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    // <T> T --> Herhangi bir veri tipini temsil eder. (Generic)
    // readValue() metodu, birinci parametrede aldığı String datayı, ikinci parametrede belirttiğimiz data tipine çevirir.
    public static <T> T convertJsonToJava(String json, Class<T> cls){ // Generic Method
        //Buradaki <T> T, buraya ne koyarsan kabul edilir anlaminda herhangi bir sey anlamina geliyor. Cünkü String veya Object gibi vs diyemeyiz. Cünkü bunlar da birer belirli veri tipi.
        //Yine herhangi bir Class olabilir bu nedenle Class<T> cls, yaptik.
        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

