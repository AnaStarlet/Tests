import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testSuccessfulLogin() {
        loginPage.login("standard_user", "secret_sauce");

        assertEquals("Products", loginPage.getPageTitle(), "Должен отображаться заголовок Products");
    }

    @Test
    void testLoginWithWrongPassword() {
        loginPage.login("standard_user", "wrong_password");

        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Текст ошибки не совпадает!");
    }
}
