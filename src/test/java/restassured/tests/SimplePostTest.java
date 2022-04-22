package restassured.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import restassured.BaseClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimplePostTest extends BaseClass {

    @Test
    public void postTest1() {
        String testBody = "Hello World!";
        given().log().all().and().contentType(ContentType.TEXT)
                .body(testBody)
                .when().post("/post")
                .then().log().all().statusCode(200)
                .body("data", equalTo(testBody));
    }

    @Test
    public void postTest2() {
        String param1 = "Hello";
        String param2 = "World";
        String expectedDataValue = String.format("foo1=%s&foo2=%s", param1, param2);
        given().log().all().and().contentType(ContentType.JSON)
                .formParam("foo1", param1)
                .formParam("foo2", param2)
                .when().post("/post")
                .then().log().all().statusCode(200)
                .body("data", equalTo(expectedDataValue));
    }
}
