package task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SecFunctionTest {

    // Тест для x = 0 (sec(0) должно равняться 1)
    @Test
    public void testSecAtZero() {
        SecFunction secFunc = new SecFunction();
        double x = 0.0;
        double expected = 1.0;
        double result = secFunc.sec(x);
        System.out.println("Test sec(0): x = " + x + ", expected = " + expected + ", result = " + result);
        assertEquals(expected, result, 1e-10, "sec(0) должно равняться 1");
    }

    // Тест для малых положительных значений
    @Test
    public void testSecSmallPositive() {
        SecFunction secFunc = new SecFunction();
        double x = 0.1;
        double expected = 1.0 / Math.cos(x);
        double result = secFunc.sec(x);
        System.out.println("Test sec(0.1): x = " + x + ", expected = " + expected + ", result = " + result);
        assertEquals(expected, result, 1e-8, "Неверное приближение для x = 0.1");
    }

    // Тест для среднего положительного значения
    @Test
    public void testSecMediumPositive() {
        SecFunction secFunc = new SecFunction();
        double x = 0.5;
        double expected = 1.0 / Math.cos(x);
        double result = secFunc.sec(x);
        System.out.println("Test sec(0.5): x = " + x + ", expected = " + expected + ", result = " + result);
        assertEquals(expected, result, 1e-6, "Неверное приближение для x = 0.5");
    }

    // Тест для отрицательного значения
    @Test
    public void testSecNegative() {
        SecFunction secFunc = new SecFunction();
        double x = -0.3;
        double expected = 1.0 / Math.cos(x);
        double result = secFunc.sec(x);
        System.out.println("Test sec(-0.3): x = " + x + ", expected = " + expected + ", result = " + result);
        assertEquals(expected, result, 1e-8, "Неверное приближение для x = -0.3");
    }

    // Тест для значения, близкого к границе сходимости (но внутри)
    @Test
    public void testSecBoundary() {
        SecFunction secFunc = new SecFunction();
        double x = 1.4; // π/2 ≈ 1.57; выбираем значение внутри области сходимости
        double expected = 1.0 / Math.cos(x); // ~5.883490084827342
        double result = secFunc.sec(x);
        System.out.println("Test sec(1.4): x = " + x + ", expected = " + expected + ", result = " + result);
        assertEquals(expected, result, 0.5, "Неверное приближение для x = 1.4");
    }
}
