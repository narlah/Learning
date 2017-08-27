package algorithmic;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class PiToXNilakanthaSeries {
    public static void main(String[] args) {
        BigDecimal pi = new BigDecimal(3);
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(80);
        for (int i = 0, j = 2; i <= 1000; i++, j += 2) {
            int coef = j * (j + 1) * (j + 2);
            BigDecimal pa = new BigDecimal(Math.pow(-1, i % 2) * 4d / ((double) coef));
            pi = pi.add(pa);
        }
        System.out.println(df.format(pi));
    }
}
