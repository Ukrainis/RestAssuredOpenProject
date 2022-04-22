package restassured.tests;

import org.junit.jupiter.api.Test;
import restassured.BaseClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleDeleteTest extends BaseClass {

    @Test
    public void deleteTest1() {
        String testBody = "Hello World!";
        given().log().all()
                .body(testBody)
                .when().delete("/delete")
                .then().log().all().statusCode(200)
                .body("data", equalTo(testBody));
    }
}
