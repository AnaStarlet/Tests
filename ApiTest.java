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
                .statusCode(200) // Проверяем, что сервер ответил "ОК"
                .body("login", equalTo("octocat")) // Проверяем, что в ответе пришло нужное имя
                .body("id", equalTo(583231)); // Проверяем ID пользователя
    }
}
