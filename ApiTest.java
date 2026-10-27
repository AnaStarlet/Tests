import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    void testGetUser(){
        given()
                .when()
                .get("https://api.github.com/users/octocat")
                .then()
                .statusCode(200) 
                .body("login", equalTo("octocat")) 
                .body("id", equalTo(583231)); 
    }
}
