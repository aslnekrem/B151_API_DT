package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */

    @Test
    public void get01(){

        //1- Set the URL = URL'i tanımla
        //Birinci Yöntem
        //Sadece tek bir islem yapacaksak ikinci yöntem ama bircok islem yapacaksak birinci yöntem daha iyi olur
        String url = "https://restful-booker.herokuapp.com/booking/55";
        //Ikinci Yöntem
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/55"; //String url yerine RestAssured kutuphanesini kullanarak url'i belirtmek bizim API testlerine hakim oldugumuzu gosterir
        //2- Set the expected data = Beklenen dataları ayarla
        //Bunu kullanmadik bu adimda cünkü kullanmiyoruz. get(); isleminde beklenen datmiz yok, datamiz yok url ayarlayarak getrequest ypabiliyoruz
        //3- Send the request and get the response = İsteği gönder ve cevabı al
        Response response = given().when().get(); //given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarinin hazirlanmasi
        response.prettyPrint();
        //4- Do assertion = Doğrulama yap
        response
                .then() // Assertion metodu, Assertion gibi dogrulama yaparken bu methodu kullaniyoruz, sonrasinda asagidaki gibi devam ediyoruz
                .statusCode(200) // Status kodun 200 olduğunu doğruladık
                .contentType("application/json") // Content type'ın "application/json" olduğunu doğruladık
                .statusLine("HTTP/1.1 200 OK"); // Status Line'ın "HTTP/1.1 200 OK" olduğunu doğruladık

    }
}
