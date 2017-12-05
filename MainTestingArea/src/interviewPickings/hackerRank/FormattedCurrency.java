package interviewPickings.hackerRank;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattedCurrency {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //double payment = scanner.nextDouble();
        //scanner.close();
        double payment = 12324.134;


        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println("India: " + NumberFormat.getCurrencyInstance(Locale.ENGLISH).format(payment).replace("¤", "Rs."));
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    }
}
