package post_requests;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
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
        response body is like
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
     */

    @Test
    public void post03() {
        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55, "Tidy your room", false);//Bu kisma dikkat et normalde burada Map yapiyorduk

        // Send the request and get the response
        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        // Do assertion
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);//Bu kisma dikkat et normalde burada Map yapiyorduk
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());
    }
}
//@JsonIgnoreProperties(ignoreUnknown = true) //Bunlarin disinda bir data geldigi zaman gormezden gel, örnekte response'da tanimlanamayan id alani var hatasi vardi bu nedenle parametre hatasi aldik ama bu @ ile bunlari görmezden gel dedik, pojo class''in üstünde.
//Ic ice jsonlar geliyorsa ayri ayri pojo class lar olusturmamiz gerekir
//pojo class variable lari private yapip getter, setter methodlariyla cagisirip degisiklik yaptigimiz class lardir.
// UI Testi ---> API Testi ---> Database testi == E2E TEST, bunlari intellij'De yapabiliyoruz birlikte ama Postman'de sadece API testleri yapabildigimiz icin intellij'De kullaniyoruz. Yani bize tam otomasyonu intellij sagliyor, Postman degil
// Register
/*
//UI Testi----> API Testi ------> Database Testi
//Postman'de API testi yapabiliriz ancak UI ve DataBase Testlerini yapamayiz.
//Bir veri gonderiyoruz, register islemi yapiyoruz. Bunu UI'da yaptik ve bilgileri intellij'de bir pojo class'ta kaydedebiliriz
//Bu kayitli bilgileri UI ile DataBase Testleri ile kontrol edebiliriz. UI, DataBase ve API testlerini yapabildigimizde full stack Otomation Engineer olabiliriz. Bu testleri intellij'de yapabiliriz.
 */