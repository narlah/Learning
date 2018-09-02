package interviewPickings.leetcode;

public class SimpleCalculator2 {

    public int calculate(String s) {
        String[] ss = ("+" + s + "+").replaceAll(" ", "").split("(?<=[-+*/])|(?=[-+*/])");
        int total = 0, term = 0, count = 0;
        String c;
        while (count < ss.length) {
            c = ss[count++];
            if (c.equals("+") || c.equals("-")) {
                total += term;
                if (count + 1 < ss.length)
                    term = Integer.parseInt(ss[count++] + "") * (c.equals("+") ? 1 : -1);
            } else {
                int n = Integer.parseInt(ss[count++] + "");
                if (c.equals("*"))
                    term *= n;
                else
                    term /= n;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        SimpleCalculator2 sim = new SimpleCalculator2();
        System.out.println(sim.calculate("45+12*5"));
    }
}
