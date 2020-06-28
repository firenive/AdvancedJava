package JUnit.Lesson1;

import org.junit.Test;

public class MyMathTest {
    @Test (expected = ArithmeticException.class) // ожидаем что в тестовом сценарии будет выброшено указанное исключение
    // Если исключения нет тест валится

    public void checkZeroDenominator() {
        MyMath.divide(10, 0); // TestPassed
    }
    @Test(expected = ArithmeticException.class)
    public void checkZeroDenominator2() {
        MyMath.divide(10, 5); // TestFailed
    }

}
