package interviewPickings.hackerRank;

import java.util.Arrays;
import java.util.StringTokenizer;

public class LookAheadLookBehind {
    public static void main(String[] args) {
        String z = "[[a]{b}[[c]d]()]";
        String regEx = "(?<=[{}()\\[\\]])|(?=[{}()\\[\\]])";
        System.out.println(Arrays.toString(z.split(regEx)));
        StringTokenizer st = new StringTokenizer(z, "[]{}()");


        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
