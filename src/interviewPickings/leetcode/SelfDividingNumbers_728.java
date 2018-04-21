package interviewPickings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfDividingNumbers_728 {
    public static void main(String[] args) {
        SelfDividingNumbers_728 sss = new SelfDividingNumbers_728();
        System.out.println(Arrays.toString(sss.selfDividingNumbers(1, 22).toArray()));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
//        int counter10 = left % 10-1;
        for (int i = left; i <= right; i++) {
//            counter10++;
//            if (counter10 == 10) {
//                counter10 = 0;
//                continue;
//            }
            if (checkSelfDivide(i)) result.add(i);
        }

        return result;
    }

    public boolean checkSelfDivide(int number) {
        int a = number;
        while (a > 0) {
            int n = a % 10;
            if (n == 0 || number % n != 0) return false;
            a = a / 10;
        }
        return true;

    }

}
