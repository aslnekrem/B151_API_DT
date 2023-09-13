package tekrar.test_data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonPlaceHolderTestData {
    public Map<String, Object> expectedDataMapper(Integer userId, String title, Boolean completed) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", userId);
        expectedData.put("title", title);
        expectedData.put("completed", completed);
        return expectedData;

    }
}
