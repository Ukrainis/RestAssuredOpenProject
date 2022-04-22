package restassured.tests;

import io.restassured.http.ContentType;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import restassured.BaseClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleGetTest extends BaseClass {

    @Test
    public void getTest1() {
        given()
                .when().get("/get")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getTest2() {
        given().log().all()
                .param("foo1", "bar").param("foo2", "bar2")
                .when().get("/get")
                .then().log().all().statusCode(200)
                .body("args.foo1", equalTo("bar"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void getTest3() {
        given().log().all()
                .accept(ContentType.XML)
                .param("foo1", "bar").param("foo2", "bar2")
                .when().get("/get")
                .then().log().ifError().statusCode(200)
                .body("args.foo1", equalTo("bar"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void getTest4_basicAuthPositive() {
        given().log().all()
                .auth().basic("postman", "password")
                .when().get("/basic-auth")
                .then().log().all()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }

    @Test
    public void getTest6_Delay() {
        String time = "5";
        given().log().all().pathParam("delay", time)
                .when().get("/delay/{delay}")
                .then().log().all()
                .statusCode(200)
                .body("delay", equalTo(time));
    }
}
