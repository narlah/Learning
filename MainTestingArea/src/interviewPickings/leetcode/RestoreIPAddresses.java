package interviewPickings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddresses res = new RestoreIPAddresses();
        System.out.println(Arrays.toString(res.restoreIpAddresses("2222").toArray()));
        System.out.println(Arrays.toString(res.restoreIpAddresses("255111222333").toArray()));
        System.out.println(Arrays.toString(res.restoreIpAddresses("2551112223331").toArray()));
        System.out.println(Arrays.toString(res.restoreIpAddresses("2551112220").toArray()));
        System.out.println(Arrays.toString(res.restoreIpAddresses("111").toArray()));
        System.out.println(Arrays.toString(res.restoreIpAddresses("25525511135").toArray()));
        System.out.println(Arrays.toString(res.restoreIpAddresses("010010").toArray()));
        System.out.println(Arrays.toString(res.restoreIpAddresses("172162541").toArray()));
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() <= 3 || s.length() > 12)
            return Collections.emptyList();
        ArrayList<String> result = new ArrayList<>();
        placeDotsRecursivelly("", s, result, 0);
        return result;
    }

    public void placeDotsRecursivelly(String begin, String remainder, List<String> result, int dotsPlaced) {
        if (dotsPlaced == 4) {
            result.add(begin + remainder);
            return;
        }
        int remLength = remainder.length();
        for (int i = 1; i <= 3; i++) {
            if (i > remLength || remLength > (3 - dotsPlaced) * 3 + i)
                continue;
            String reminderSubs = remainder.substring(0, i);
            if (i == 3 && Integer.valueOf(reminderSubs) > 255 || ((i == 2 || i == 3) && reminderSubs.charAt(0) == '0'))
                continue;
            String newBegin = begin + reminderSubs + (dotsPlaced < 3 ? '.' : "");
            String newReaminder = remainder.substring(i);
            placeDotsRecursivelly(newBegin, newReaminder, result, dotsPlaced + 1);
        }
    }
}