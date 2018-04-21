package interviewPickings;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionMaxPositiveLine {
    public static void main(String[] args) {
        SolutionMaxPositiveLine sol = new SolutionMaxPositiveLine();
        ArrayList<Integer> a = sol.maxset(new ArrayList<Integer>(Arrays.asList(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421)));
        System.out.println("=>" + Arrays.toString(a.toArray()));
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long x1 = 0, y1 = 0, x2 = 0, y2 = 0, sum1 = 0, sum2 = 0;
        for (int i : a) {
            if ((sum1 == -1 || i < 0)) {
                if (sum1 == -1)
                    sum1 = i;
                if (sum1 == sum2) {
                    if ((y1 - x1) > (y2 - x2)) {
                        x2 = x1;
                        y2 = y1;
                        sum2 = sum1;
                    }
                    if ((y1 - x1) == (y2 - x2)) {
                        x2 = x1 < x2 ? x1 : x2;
                        y2 = x1 < x2 ? y1 : y2;
                        sum2 = x1 < x2 ? sum1 : sum2;
                    }
                }
                if (sum1 > sum2) {
                    x2 = x1;
                    y2 = y1;
                    sum2 = sum1;
                }
                x1 = y1 + 1;
                y1 = x1;
                sum1 = -1;
                continue;
            }
            y1 += 1;
            sum1 += i;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (x2 == y2) {
            int c = a.get((int) x2);
            if (c < 0)
                return new ArrayList<Integer>();
            ret.add(c);
        } else {

            for (long i = x2; i < y2; i++) {
                ret.add(a.get((int) i));
            }
        }
        return ret;
    }
}
