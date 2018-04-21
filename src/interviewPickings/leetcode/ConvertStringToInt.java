package interviewPickings.leetcode;

public class ConvertStringToInt {
    public static void main(String[] args) {
        ConvertStringToInt convert = new ConvertStringToInt();
        System.out.println(convert.myAtoi("9223372036854775809"));
        System.out.println(convert.myAtoi("abc"));

        System.out.println(convert.myAtoi(""));
        System.out.println(convert.myAtoi("+"));
        System.out.println(convert.myAtoi("-2"));
        System.out.println(convert.myAtoi("132"));
        System.out.println(convert.myAtoi("-132 12311111"));
        System.out.println(convert.myAtoi("+132,123"));
        System.out.println(convert.myAtoi("+-,132,123"));
    }

    public int myAtoi(String str) {
        String numbersStr = str.replaceAll("[^\\d,+-.]", "");
        if (numbersStr.equals("") || numbersStr.length()==0)
            return 0;
        int coef = 1 ;
        char sign = numbersStr.charAt(0);
        if (sign=='+' || sign =='-'){
            coef = sign=='+'?1:-1;
            numbersStr = numbersStr.substring(1);
        }
//        numbersStr = str.replaceAll("[^\\d,]", "");
//        if (numbersStr.equals(""))
//            return 0;
//        int comma = numbersStr.lastIndexOf(',');
//        if (comma != -1)
//            numbersStr = numbersStr.substring(0, comma);
        double result = Double.valueOf(numbersStr);
        return (int) (result % Integer.MAX_VALUE )* coef;
    }

    /* fuck this problem really
     +-2 would be 0 ??!?!?! why
     + 413 should be 0 as well , wtf ... i mean why ... meh

     the problem has 4 cases
     1. overflow
     2. illegal inputs
     3. spaces on both ends
     4. sign
     screw this comma and everything ...
    */
}

