package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
/*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status code 404 olmalı
        And
            Status Line "HTTP/1.1 404 Not Found" olmalı
        And
            Response body "Not Found" içermeli
        And
            Response body "TechProEd" içermemeli
        And
            Server değeri "Cowboy" olmalı
    */

public class Get02 {
    @Test
    public void get02() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/0";
        given().
                when(). //Bunu koymasan da olur ama when'i koymak daha güzel gösteriyor. Fakat and,assertthat cok gereksiz
                get().
                then()
                .statusCode(404)
                .and().assertThat()
                .statusLine("HTTP/1.1 404 Not Found")
                .and().assertThat()//Bu olduugu zamanda olmadigi zamanda hata vermez cok da bir geregi yok. Görünüs icin eklemek istersen ekleyebilirsin
                .body(containsString("Not Found"))
                .and().assertThat()
                .body(not(containsString("TechProEd")))
                .and().assertThat()
                .header("Server", "Cowboy");
        // Hamcrest Matchers Kütüphanesinden Import ettik

        //Testi run edince kimimiz hata aldik. HttpResponseException aldilar. 404 Not Found sonucu aldilar. Aslinda
        //sonuc 404 Not Found olmaliydi. Bir sey bulamadigindan exception fuirlatildi. Pom.xml'i actik ve properties tagi
        //altinda iki maven satirindan sonra <argLine>-Duser.language=en</argLine> ekledik



    }
}
