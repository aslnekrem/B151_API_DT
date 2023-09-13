package get_requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
public class Get03 {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type “application/json” olmalı
        And
            “title” şu metni içermeli: “et itaque necessitatibus maxime molestiae qui quas velit”,
        And
            “completed” değeri false olmalı
        And
            “userId” değeri 2 olmalı
     */
    @Test
    public void get03() {
        // HARD ASSERTION
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/todos/23";
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)//
                .body("title", containsString("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed", equalTo(false))
                .body("userId", equalTo(2));
    }
    @Test
    public void get031() {
        //SOFT ASSERTION yapmak icin bütün body'leri iç içe geçirmemiz gerekiyor.
        // SOFT ASSERTION
        //Mesela uygulamada bir hata var ve düzelmiyor, o zaman soft assertion kullaniriz ki diger testlerimizi engellemesin
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/todos/23";
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title", containsString("et itaque necessitatibus maxime molestiae qui quas velit")
                        ,"completed", equalTo(false)
                        , "userId", equalTo(2));
    }
}