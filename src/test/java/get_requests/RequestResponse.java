package get_requests;


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RequestResponse {
    /*
        1- Manuel API testi için Postman kullanıyoruz.
        2- API otomasyon testi için REST Assured kütüphanesini kullanıyoruz.
        3- Otomasyon kodlarının yazımı için şu adımları izleriz:
            A- Gereksinimleri anlama
            B- Test senaryosu yazma
                a- Test senaryosu yazmak içi Gherkin dilini kullanıyoruz.
                    - Given:Ön Kosullar: Endpoint, body ...
                    - When: Islemler:  get, put, post gibi işlemler
                    - Then: Dönütler: Assertion, Close ...
                    - And: Çoklu işlemlerin art arda yapıldığı zaman kullanılır.
            C- Otomasyon kodlarını yazarken şu adımları izleriz:
                1- Set the URL = URL'i tanımla
                2- Set the expected data = Beklenen dataları ayarla
                3- Send the request and get the response = İsteği gönder ve cevabı al
                4- Do assertion = Doğrulama yap

     */
                //1- Set the URL = URL'i tanımla
                //2- Set the expected data = Beklenen dataları ayarla
                //3- Send the request and get the response = İsteği gönder ve cevabı al
                //4- Do assertion = Doğrulama yap
    public static void main(String[] args) {
        // Get testi nasıl yapılır?
        String url = "https://petstore.swagger.io/v2/pet/3504";
        Response response = given().when().get(url);
        response.prettyPrint();//response.prettyPrint();   //response dan gelen cevabi json olarak yazdirmaya yarar
        //response.prettyPrint();
        // Status Code nasıl yazdırılır?
        System.out.println("Status Code: " + response.statusCode());
        //statusCode() ile getStatusCode() methodlari ayni islemi gorur.
        System.out.println("__________________________");
        // Content Type nasıl yazdırılır?
        System.out.println("Content Type: " + response.contentType());
        System.out.println("__________________________");
        // Status Line nasıl yazdırılır?
        System.out.println("Status Line: " + response.statusLine());
        System.out.println("__________________________");
        // Header'daki veriler nasıl yazdırılır?
        System.out.println("Header | Server: " + response.header("Server"));
        System.out.println("__________________________");
        System.out.println("Header | Connection: " + response.header("Connection"));
        System.out.println("__________________________");
        // Headers nasıl yazdırılır?
        System.out.println("Headers: " + response.headers());
        System.out.println("__________________________");
        // Time nasıl yazdırılır?
        System.out.println("Time: " + response.time());


        //DIKKAT!!! --> Selenium web otomasyonu(UI-User Interface) icin, rest-assured kutuphanesi ise API testleri icin kullanilir
        //Request'in body bolumunu Swagger dokumanindan aliriz. Bazi firmalarin farkli dokumantasyonu olabilir ama genelde swagger dan aliriz
        /*
        post ve put islemlerinde request'in body bolumune ihtiyac duyulurken
         get ve delete islemlerinde request'in body bolumune gerek yoktur.
         */

     /*
        Request ==> istek
        Response ==> istege gonderilen cevap
        Status code = Gelen cevabin basari durumu
        Post ==> creat ==> Request olusturma islemi => Istek olusturma
        Get ==> read ==>Request sorgulama => Istegin olusup olusmadigini veya
        verilen url deki bilgilerin dogrulugunu sorgulama
        Put ==> update ==> Request i update etme => Istegi guncelleme
        Delete ==> delete ==> Request'i delete etme => Istegi silme islemi
        Bu islemlere kisaca CRUD islemleri denir
         */
        //String url yerine RestAssured kutuphanesini kullanarak url'i belirtmek bizim API testlerine hakim oldugumuzu gosterir

    }
}
