package framework;


import com.google.gson.Gson;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class BaseAdapter {
    PropertyReader propertyReader = new PropertyReader("config.properties");
    protected Gson gson = new Gson();

    public String get(String uri, int status) {
        String string = given().
                header("Content-type", "application/json").
                get(propertyReader.getProperty("URL") + uri).
                then().
                log().
                all().
                statusCode(status).
                and().
                contentType(ContentType.JSON).
                extract().body().asString();

        return string;
    }
    public String post(String body, String uri, int status) {
        String string = given().
                header("Content-type", "application/json").
                body(body).
                when().
                post(propertyReader.getProperty("URL") + uri).
                then().
                log().
                all().
                statusCode(status).
                and().
                contentType(ContentType.JSON).
                extract().body().asString();
        return string;
    }
}
