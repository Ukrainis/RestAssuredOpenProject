package restassured.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import restassured.BaseClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimplePutTest extends BaseClass {

    @Test
    public void putTest1() {
        String testBody = "Hello World!";
        given().log().all().and().contentType(ContentType.TEXT)
                .body(testBody)
                .when().put("/put")
                .then().log().all().statusCode(200)
                .body("data", equalTo(testBody));
    }
}
