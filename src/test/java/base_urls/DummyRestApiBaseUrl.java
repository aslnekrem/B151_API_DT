package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void Setup(){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://dummy.restapiexample.com/api/v1")
                .build();
    }
    // tekrarlı olarak kullanılan değerlerler burada yazılır
}