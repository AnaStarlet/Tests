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
        // 1. Запускаем браузер (БЕЗ ВСЯКИХ OPTIONS)
        driver = new ChromeDriver();
        // 2. Открываем сайт
        driver.get("https://www.saucedemo.com/");
        // 3. Растягиваем окно
        driver.manage().window().maximize();
        // 4. Создаем страницу
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
        // 3. Весь код поиска элементов исчез. Остался только вызов метода страницы!
        loginPage.login("standard_user", "secret_sauce");

        // Проверяем заголовок через метод страницы
        assertEquals("Products", loginPage.getPageTitle(), "Должен отображаться заголовок Products");
    }

    @Test
    void testLoginWithWrongPassword() {
        loginPage.login("standard_user", "wrong_password");

        // Проверяем ошибку через метод страницы
        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Текст ошибки не совпадает!");
    }
}