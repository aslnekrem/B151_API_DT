package practice01;

import io.restassured.RestAssured;
import org.junit.Test;

public class Get01_IDileContactGetirme {
    @Test
    public void get01() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com/";
        RestAssured.basePath = "/contacts";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGQ3YzU1YzlhNjk0ZTAwMTMwZjIwMTEiLCJpYXQiOjE2OTE4NjM3NTN9.Oc8KlMP0iJ99sXfPDP3JonaYCZCOidh2s63gphVgcpw";


    }
}
