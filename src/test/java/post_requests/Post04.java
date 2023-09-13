package post_requests;

import base_urls.GoRestBaseUrl;
import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04 extends HerokuAppBaseUrl {
    //response as methodu sadece json ve java datalari arasinda donusum yapmaz.
    //jackson-databind ve jackson.datatype dependency leri ile birlikte response as() methodu Integer variable i String'e, String'i Local Date'e gibi farkli veri tiplerini birbirine cevirebilmemize imkan tanir



    /*
        Given
          1)  https://restful-booker.herokuapp.com/booking
          2) {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
              }
        When
            I send POST Request to the URL
        Then
            Status code is 200
        And
            Response body is like
                 {
                    "bookingid": 16,
                    "booking" :{
                        "firstname": "Ali",
                        "lastname": "Can",
                        "totalprice": 999,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2021-09-21",
                            "checkout": "2021-12-21"
                        },
                        "additionalneeds": "Breakfast"
                     }
                  }
     */

    @Test
    public void post04() {
        //response'da kac scope varsa o kadar pojo olmali. Burada 3 tane vardi. BookingResponsePojo'yu istedigimiz sirada olusturabiliriz. Ancak ona expected data kisminda yer yok. En buyuk olan hepsini kapsayan pojoyu
        //Do assertion icine yaziyoruz.
        //Ignore et deseydik null gelirdi cünkü bizim istedigimiz ic data, üst datayi ignore et dersek bizim istedigimiz ic data'lar null dönüyor.
        //Yandakini ignore edersen sorun yok. Ama icerisi lazimsa ignore edersen null dönüyor. Biz burada bookingid'yi ignore etmeyi denedik ama null döndü. Bu yüzden cerceveyi genisletip yeni pojo yaptik

        // Set the URL
        spec.pathParam("first", "booking");

        // Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2021-09-21", "2021-12-21");
        BookingPojo expectedData = new BookingPojo("Ali", "Can", 999, true, bookingDates, "Breakfast");
        System.out.println(expectedData.toString());

        // Send the request and get the response
        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        // Do assertion
        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);
        System.out.println(actualData);
        //Request'de bu pojo'nun bulunmasina gerek yoktu. Bu nedenle Response kisminda yaptik.

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(bookingDates.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());
        /*
        assertEquals(expectedData.getBookingDates(), actualData.getBooking().getBookingDates());  -> diyebilirdik.
        Bu sekilde toplu bir dogrulama yapar fakat!! iceride bir hata olursa hangisinde oldugunu bilemeyiz. Hata gizleme
        olur ISTQB'deki gibi. Bu nedenle tek tek dogrulamak daha iyi.
         */

    }
}