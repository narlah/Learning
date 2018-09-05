import java.util.Arrays;
import java.util.StringTokenizer;

public class f7 {
    // ***************************f6**********************************

    // ***************************f6**********************************
    public static void main(String[] args) throws InterruptedException {
        // ***************************f6**********************************
        System.out.println(a());
        return;
        // ***************************************************************

    }

    private static int a() {
        String z = "[[a]{b}[[c]d]()]";
        String regEx = "(?<=[{}()\\[\\]])|(?=[{}()\\[\\]])";
        System.out.println(Arrays.toString(z.split(regEx)));
        StringTokenizer st = new StringTokenizer(z, "[]{}()");


        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        return 0;
    }
}