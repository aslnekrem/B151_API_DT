package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerokuAppBaseUrl {
   /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
            {
                "firstname": "Jane",
                "lastname": "Doe",
                "totalprice": 111,
                "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                "additionalneeds": "Extra pillows please"
            }
     */

    @Test
    public void get09() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 2500);

        // Set the expected data
        Map<String, String> bookingdatesData = new HashMap<>();
        bookingdatesData.put("checkin", "2018-01-01");
        bookingdatesData.put("checkout", "2019-01-01");
        System.out.println("BookingDates Data: " + bookingdatesData);

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jane");
        expectedData.put("lastname", "Doe");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesData);
        expectedData.put("additionalneeds", "Extra pillows please");
        System.out.println("Expected Data: " + expectedData);

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
        assertEquals(bookingdatesData.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesData.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));


        //Yukaridaki örnekte ic ice iki tane map var. Örnek bunun üzerine. Icerideki map bookingdates..
        /*
        Object obj = new HashMap<>();
        obj.get() --> Bu sekilde kullanamiyoruz cünkü parent'lar Child'larin method larini kullanamazlar. Bunu bu sekilde
        yazmamin amaci yukaridaki bookingdates map'i ile ilgili. get method'u Map'e ait bu nedenle Map'in icinde Object oldugu icin
        Object bu get method'unu kullanamiyor.
        ((Map)obj).get("asdas");
         */



    }

    @Test
    public void get09b() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 2500);

        // Set the expected data
        HerokuAppTestData obj = new HerokuAppTestData();
        Map<String, String> bookingdatesData = obj.bookingDateMapper("2018-01-01", "2019-01-01");
        Map<String, Object> expectedData = obj.expectedDataMapper("Jane", "Doe", 111,
                true, bookingdatesData, "Extra pillows please");

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
        assertEquals(bookingdatesData.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesData.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));
        //header, status code, time, size bilgileri response'un icerisinde mevcut. actualData ile sadece body icesindeki datalari test ettik
        //parentlar childlarin methodunu kullanamaz get methodu HashMap e ait bu nedenle Object bunu kullanamaz. Ama type casting ile bunu yapabiliriz

        //2.YOL
        //ic ice gecmis datalarda direkt nokta koyarak ulasabildigimiz icin asagidaki yolda kolay bir yol
        JsonPath json = response.jsonPath();
        assertEquals(bookingdatesData.get("checkin"), json.getString("bookingdates.checkin"));
        assertEquals(bookingdatesData.get("checkout"), json.getString("bookingdates.checkout"));

    }
}