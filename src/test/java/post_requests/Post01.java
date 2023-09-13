package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
    /*
    Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    //Hard Coding
    @Test
    public void post() {
        /*
        Data'yi asagida post icin String halinde payload olarak olusturduk. Fakat bu Hard Coding. Cünkü Post'da bir sey
        degistirmek istedigimizde bütün assertion'lari tek tek degistirmemeiz gerekiyor bu nedenle bu tercih edilmeyen
        bir yöntem. Bunun yerine Map yapmak daha mantikli. 2. Testteki gibi
         */
        //1. Set Url
        spec.pathParam("first","todos");

        //2. Set expected data
        //Literatur'De bizim girecegimiz body'nin ismi payLoad'dir. Piyasada Body'e payload denir
        String payload ="{\n" +
                "  \"userId\": 55,\n" +
                "  \"title\": \"Tidy your room\",\n" +
                "  \"completed\": false\n" +
                " }";

        // Send req and get resp
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPath json = response.jsonPath();

        assertEquals(55,json.getInt("userId"));
        assertEquals("Tidy your room",json.getString("title"));
        assertEquals(false,json.getBoolean("completed"));
        assertEquals(201,json.getInt("id"));


    }


    //Dynamic code
    @Test
    public void post01Map() {
        //1 Set Url
        spec.pathParam("first","todos");

        //2. Set expected data
        Map<String, Object> expecedData = new HashMap<>();
        expecedData.put("userID",45);
        expecedData.put("title","Tidy your room");
        expecedData.put("completed",false);
        //expecedData.put("id",201); id'i girmiyoruz cünkü body'de id yok

        //Set req and get resp
        Response response = given(spec).body(expecedData).when().post("{first}"); //Burada serializetion yapiliyor.
        //Bunun icin mvn repository'den dependency indirdik. Ve bu otomatik tercümesini yapiyor. Jackson kütüphanesini kullanarak yaptik
        response.prettyPrint();
        //Serialization, JAva objesini Java data'sini, Json'a cevirme islemi.   java object ---> json objesine çevirir.
        //IWQ: seialize nedir deserialize nedir?

        //Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class); //Deserialization yapildi.
        //Deserialization: Json objesini Java objesine ceviriyor. Deserialization object--> Java Objeect
        assertEquals(201,response.statusCode());
        assertEquals(expecedData.get("userId"),actualData.get("userId"));
        assertEquals(expecedData.get("title"),actualData.get("title"));
        assertEquals(expecedData.get("completed"),actualData.get("completed"));
        //Yukarida dynamic kod yaptik
        assertEquals(201,actualData.get("id"));
        //Burada da her sorguda id 201 döndügü icin yine Hard Coding olmadi.


    }
}
