package herokuapp_smoketest;

import static herokuapp_smoketest.C01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.ObjectMapperUtils.convertJsonToJava;
import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;
import java.util.HashMap;
import java.util.Map;

public class C04_PartialUpdateBooking extends HerokuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/:id
        And
            {
                "firstname" : "Ali",
                "lastname" : "Can"
            }
        When
            Kullanıcı PATCH request gönderir
        Then
            Status Code = 200
        And
            {
                "firstname" : "Ali",
                "lastname" : "Can",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
                },
                "additionalneeds" : "Breakfast"
            }
     */

    @Test
    public void partialUpdateBooking() {
        // Set the URL
        spec.pathParams("first", "booking", "second", bookingId);

        // Set the expected data
        HerokuAppTestData obj = new HerokuAppTestData();
        Map<String, Object> expectedData = obj.expectedDataMapper("Ali", "Can", null, null, null, null);
        /*
        Burada Pojo yerine Map kullanmamizin sebebi sadece iki deger girecegiz ve digerlerini bos yani null yapacagiz.
         Bir tane Patch islemi icin Pojo olusturmaya degmez. Biz burada 2 tane data gönderip digerlerini null birakacagiz.
         Biz burada Ali ve Can i yazip digerlerini yazmaysak ya da onlarin yerine null yazarsak bu degerler degisir.
        Ama biz bunlarin degismesini istemiyoruz. Bunlari Pojo ile yaptigimiz zaman bu degerleri null olarak degistiriyor.
         O yüzden burada Map'leri kullanmak sadece bu degerlerin degisecegi sekilde bir ayarlama yapmak, bizim icin daha iyi bir
         cözüm olacaktir, bu nedenle burada Map'leri kullandik.
         */
         /*
        Burda patch islemi ile sadece bir bolumu degistirdigimiz icin diger bolumleri
         null olarak yazdik. expectedDataMapper() methodunda zaten Parametrelerin null gelme ihtimaline
         karsi if li ifadeleri olusturduk. Patch islemi icin diye belirtmistik
         */
        // Send the request
        Response response = given(spec).body(expectedData).when().patch("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, String> actualData = convertJsonToJava(response.asString(), HashMap.class);
        // iki veri de String oldugu icin Map<String,String> yaptik. Verilerden birisi String
        // haricinde bir dataType olsaydi o zaman Map<String,Object> yapmalıydık.
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
    }
}
