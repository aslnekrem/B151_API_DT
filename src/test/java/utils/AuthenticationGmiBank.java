package utils;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class AuthenticationGmiBank {
    public static String generateToken() {
        String body = "{\n" +
                "    \"password\": \"Mark.123\",\n" +
                "    \"rememberMe\": true,\n" +
                "    \"username\": \"mark_twain\"\n" +
                "}";
        //Yukaridaki verileri body ye koyup bir post islemi yaptik
        Response response = given().body(body).contentType(ContentType.JSON).when().post("https://gmibank.com/api/authenticate");
        response.prettyPrint();
        //Asagida gelen response u bir container a koyabilmek icin jsonpath kullandik
        return response.jsonPath().getString("id_token");
    }
}