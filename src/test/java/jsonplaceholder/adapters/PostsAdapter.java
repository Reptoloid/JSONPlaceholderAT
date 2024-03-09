package jsonplaceholder.adapters;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import framework.BaseAdapter;
import framework.PropertyReader;
import jsonplaceholder.pojo.PostsPojo;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.google.gson.JsonParser.parseString;

public class PostsAdapter extends BaseAdapter {
    SoftAssert softAssert = new SoftAssert();

    public void getPosts(String uri, int status) {
        String response = get(uri, status);
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        System.out.println("Number of posts " + jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            Assert.assertTrue(jsonObject.get("id").getAsInt() - i == 1, "404 error");
        }
    }

    public void get99Post(int post_id, String uri, int status) {
        String response = get(uri, status);
        try {
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
            JsonObject jsonObject = jsonArray.get(post_id - 1).getAsJsonObject();
            System.out.println(post_id + " post" + jsonObject);
        } catch (Exception e) {
            status = 404;
            System.out.println("status code " + status);
        }

    }

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
    public void postPost(PostsPojo postsPojo, String uri, int status) {
        String response = post(gson.toJson(postsPojo), uri, status);
        JsonObject jsonObject = parseString(response).getAsJsonObject();
        int userId = jsonObject.get("userId").getAsInt();
        int id = jsonObject.get("id").getAsInt();
        String title = jsonObject.get("title").getAsString();
        String body = jsonObject.get("body").getAsString();
        softAssert.assertEquals(userId, postsPojo.getUserId(), "UserId are not equal");
        softAssert.assertEquals(id, postsPojo.getId(), "Id are not equal");
        softAssert.assertEquals(title, postsPojo.getTitle(), "Title are not equal");
        softAssert.assertEquals(body, postsPojo.getBody(), "Body are not equal");
        softAssert.assertAll();

    }
}
