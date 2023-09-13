package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Patch01 extends JsonPlaceHolderBaseUrl {

    //Parcali Update islemi diyebiliriz patch icin. Put'da hepsini düzenliyorduk bütün body'i, Patch'de istedigimiz bir data'yi tek basina düzenleyebiliriz.
    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
              "title": "Wash the dishes"
           }
    When
      I send PATCH Request to the Url
    Then
          Status code is 200
          And response body is like
              {
                "userId": 10,
                "title": "Wash the dishes",
                "completed": true,
                "id": 198
              }
     */

    @Test
    public void patch01() {
        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> payLoad = obj.expectedDataMethod(null, "Wash the dishes", null); //Bu bizim gönderdigimiz data, sadece title'in degismis olmasini istiyoruz
        Map<String, Object> expectedData = obj.expectedDataMethod(10, "Wash the dishes", true);
        /*
        expectedData.put("userId",10); Eger bu sekilde eklersek request olarak bu deger de gider. Bizim istedigimiz ise
        body zaten mevcut sadece bir degisiklik yapmak ve dogrulamak. Bunun icin ikinci bir Map olusturduk --> payload

         */


        // Send the request and get the response
        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();
        //Ya da ikinci bir map olusturmadan bunu -> expectedData.put("userId",10); burada da ekleyebilirsin. Amac request olarak sadece istenilen yeri degistirmek

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

        //

    }
}
