package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponsePojo;
import utils.ObjectMapperUtils;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
/*
 Given
        https://dummy.restapiexample.com/api/v1/update/21
    And
        Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                    }
    When
        User sends PUT request
    Then
        Status code should be 200
    And
        Response body should be like the following:  //Response böyle olmali derken böyle dönecek anlaminda. Yani response'un her asamasini dogrula anlaminda degil bu. Mesela burada
                                                            //id'de olabilirdi, bu onu dogrulayacagimiz anlamina gelmez
                    {
                        "status": "success"
                        "data": {
                            "employee_name": "Ali Can"
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }

 */

    @Test
    public void put() {
        // Set Url
        spec.pathParams("first","update","second",21);

        //Set Expected Data
/*
        String str = "{\n" +
                "\"employee_name\": \"Ali Can\",\n" +
                "\"employee_salary\": 111111,\n" +
                "\"employee_age\": 23,\n" +
                "\"profile_image\": \"Perfect image\"\n" +
                "}";
        Map<String, Object> expectedDAtaMap = ObjectMapperUtils.convertJsonToJava(str, HashMap.class);

 */


        DummyDataPojo payload = new DummyDataPojo("Ali Can",111111,23,"Perfect image");
        System.out.println("payload = " + payload);

        // Send Req get Response
        Response response =given(spec).body(payload).when().put("{first}/{second}");
        response.prettyPrint();

        //   expectedDAtaMap.put("status","success");
        //   expectedDAtaMap.put("message","Successfully! Record has been updated.");

        // Do assertion
        DummyResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyResponsePojo.class);

        //   Map<String,Object> actualData2 = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(payload.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(payload.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(payload.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(payload.getProfile_image(),actualData.getData().getProfile_image());
        //Text'de ne yaziyorsa onu dogrula asagidakiler yazmiyor biz yazdik sadece
        assertEquals("success",actualData.getStatus());
        assertEquals("Successfully! Record has been updated.",actualData.getMessage());

      /*  assertEquals(expectedDAtaMap.get("status"),actualData2.get("status"));
        assertEquals(expectedDAtaMap.get("message"),actualData2.get("message"));
       */

    }
}
