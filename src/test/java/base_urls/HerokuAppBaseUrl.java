package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationHerokuApp.generateToken;

public class HerokuAppBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                setContentType(ContentType.JSON) // Burda Base Url e set content type i ekledik. Post isleminde hangi veri turu ile gonderigimizi belirtmezsek Internal Server Error hatasi aliriz
                //Postman'de de post yaparken Json seciyorduk hatirla. Data türünü belirtmemiz gerekli
                .addHeader("Cookie", "token="+generateToken())
                .build();
        /*
        Tekrarli olarak kullanilan degerler burada yazilir.
        Bütün sorgularda ortak olarak kullanilacak seyler buraya yazilircookies... authorisation... gibi.. ,
         degiskenlik gösteriyorsa buraya yazilmaz.
         */

    }










}
