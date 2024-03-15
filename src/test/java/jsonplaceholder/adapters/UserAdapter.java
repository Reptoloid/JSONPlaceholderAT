package jsonplaceholder.adapters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import framework.BaseAdapter;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UserAdapter extends BaseAdapter {

    public void getUsers(int user_id,String uri, int status) {
        String response = get(uri, status);
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        System.out.println("Number of posts " + jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            Assert.assertTrue(jsonObject.get("id").getAsInt() - i == 1, "404 error");
        }
        JsonObject jsonObject = jsonArray.get(user_id-1).getAsJsonObject();
        System.out.println("Fiffth element is: " + jsonObject);
    }
}
