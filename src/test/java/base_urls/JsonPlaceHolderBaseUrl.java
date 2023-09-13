package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();
        //Put veya post yaparken gönderecegimiz body'nin Content type'ini yazmaliyiz. Sürekli yazip ugrasmamak icin buraya ekledik.
        /*
        Tekrarli olarak kullanilan degerler burada yazilir.
        Bütün sorgularda ortak olarak kullanilacak seyler buraya yazilircookies... authorisation... gibi.. ,
         degiskenlik gösteriyorsa buraya yazilmaz.
         */

    }










}
