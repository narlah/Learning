package interviewPickings.codeFights;

public class DenominatorRepeatingNumbersAfterDot {
    public static void main(String[] args) {
        DenominatorRepeatingNumbersAfterDot den = new DenominatorRepeatingNumbersAfterDot();
        System.out.println(den.extraCreditAssignment("0.1(02)", 990)); //15
    }

    /*
        Parentheses will be used to represent the repeating part of the decimal (eg: 3.6(81) means 3.6818181...)
        If the decimal has a repeating part, it'll always begin after the decimal point.
        It's guaranteed that for each decimal and denominator, there is a valid integer value for the numerator.
     */
    int extraCreditAssignment(String decimal, int denominator) {
        String[] arr = decimal.split("\\(|\\)");
        String r = arr[0];
        if (arr.length > 1)
            r += arr[1] + arr[1] + arr[1];
        return (int) Math.round(Double.parseDouble(r) * denominator);
    }

}
