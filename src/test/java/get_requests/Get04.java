package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseUrl {
    /*
    Given  https://jsonplaceholder.typicode.com/todos
    When   I send a GET request to the Url
    And    Accept type is "application/json"
    Then   HTTP Status Code should be 200
    And    Response format should be "application/ison"
    And    200 adet todos olmalı
    And    başlıklarından birisi  "quis eius est sint explicabo" olmalı
    And    userIds ler arasında 2, 7, and 9 bulunmalı
     */
    @Test
    public void get04() {

        //1. Set Url
        spec.pathParam("first","todos"); // "/"'dan sonraki kismi ekliyoruz, buna path paramaetresi deniliyor.
        //Buraya genelde first yaziliyor, hard code olmamasi icin.

        //2. set expected data
        //3. Send request
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        // 4. Do assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",hasSize(200))
                .body("title", hasItem("quis eius est sint explicabo"))
                .body("userId", hasItems(2, 7, 9));

        /*
        Dönen datada bize liste gelmisse özel bir bilgiye ulasmak icin index kullanilir
        Eger belirli bbirelemanin esitligini kontrol ediyorsak asagidaki gibi index'ini gireriz
        .body("[0].title", equalTo("delectus aut autem"))  bu sekilde index belirtiriz.
         */
        // hasItem --> contain() metodu gibi
        // hasItems --> containAll() metodu gibi
    }
}
