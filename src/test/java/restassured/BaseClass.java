package restassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import restassured.utils.PropertyUtils;

public class BaseClass {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = PropertyUtils.getPropertyValueByKey("baseUrl");
    }
}
