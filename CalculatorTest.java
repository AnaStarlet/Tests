import org.junit.After;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest{
    private Calculator calc;
    @BeforeEach
    void setUp(){
        calc = new Calculator();
        System.out.println("создан калькулятор");
    }
    @AfterEach
    void tearDown(){
        System.out.println("тест завершён");
    }
    @Test
    void testAddiction(){
        int result = calc.add(2,4);
        assertEquals(6,result, "не 6");
    }

    @Test
    void testDivisionByZero(){
        assertThrows(ArithmeticException.class, () -> calc.divide(10,0));
    }
    @Test
    void testIsPositive(){
        assertTrue(calc.isPositive(10));
        assertFalse(calc.isPositive(-5));
    };
}


























