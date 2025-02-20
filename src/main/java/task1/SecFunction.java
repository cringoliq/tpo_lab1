package task1;

import java.math.BigDecimal;
import java.math.MathContext;

public class SecFunction {

    // Коэффициенты Эйлера заданы в виде строк для сохранения точности.
    // Формула разложения:
    //   sec(x) = ∑ₙ₌₀^∞ (-1)ⁿ * E(2n) * x^(2n) / (2n)!,
    // где при перемножении на (-1)ⁿ все слагаемые становятся положительными.
    private static final String[] EULER_NUMBERS_STR = {
            "1",              // E0
            "-1",             // E2
            "5",              // E4
            "-61",            // E6
            "1385",           // E8
            "-50521",         // E10
            "2702765",        // E12
            "-199360981",     // E14
            "19391512145",    // E16
            "-2404879675441", // E18
            "370371188237525",// E20
            "-69348874393137955",      // E22
            "15514534163557086905",     // E24
            "-452488006428250486465"    // E26
    };

    /**
     * Вычисление sec(x) через разложение в степенной ряд с использованием BigDecimal.
     * Все операции проводятся с MathContext.DECIMAL128.
     * Входное значение x преобразуется через BigDecimal.valueOf(x) для повышения точности.
     */
    public double sec(double x) {
        MathContext mc = MathContext.DECIMAL128;
        BigDecimal xBD = BigDecimal.valueOf(x);
        BigDecimal sum = BigDecimal.ZERO;
        // Задаём очень маленький порог останова
        BigDecimal tolerance = new BigDecimal("1e-30", mc);
        int n = 0;
        while (n < EULER_NUMBERS_STR.length) {
            BigDecimal euler = new BigDecimal(EULER_NUMBERS_STR[n], mc);
            // (-1)^n
            BigDecimal sign = (n % 2 == 0) ? BigDecimal.ONE : BigDecimal.valueOf(-1);
            // Вычисляем x^(2n)
            BigDecimal xPow = xBD.pow(2 * n, mc);
            // Вычисляем факториал (2n)!
            BigDecimal fact = factorialBD(2 * n, mc);
            BigDecimal term = sign.multiply(euler, mc)
                    .multiply(xPow, mc)
                    .divide(fact, mc);
            sum = sum.add(term, mc);
            // Если очередной член стал очень мал, прекращаем суммирование
            if (term.abs(mc).compareTo(tolerance) < 0) {
                break;
            }
            n++;
        }
        return sum.doubleValue();
    }

    // Вычисление факториала с использованием BigDecimal
    private BigDecimal factorialBD(int n, MathContext mc) {
        BigDecimal f = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigDecimal.valueOf(i), mc);
        }
        return f;
    }
}
