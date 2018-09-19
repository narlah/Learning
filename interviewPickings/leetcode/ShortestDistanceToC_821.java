package interviewPickings.leetcode;

import java.util.Arrays;

public class ShortestDistanceToC_821 {
    public static void main(String[] args) {
        ShortestDistanceToC_821 sh = new ShortestDistanceToC_821();
        System.out.println(Arrays.toString(sh.shortestToChar("loveleetcode", 'e')));
    }

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int firstC = S.indexOf(C + "");
        int lastC = S.lastIndexOf(C + "");
        res[firstC] = 0;
        res[lastC] = 0;
        for (int i = firstC - 1; i >= 0; i--) {
            res[i] = firstC - i;
        }
        for (int i = lastC + 1; i < S.length(); i++) {
            res[i] = i - lastC;
        }
        int curr = firstC + 1;
        for (int i = firstC + 1; i <= lastC; i++) {
            if (S.charAt(i) == C) {
                fillBetween(res, curr, i - 1);
                curr = i + 1;
            }
        }
        return res;
    }

    private void fillBetween(int[] res, int f, int l) {
        int c = 1;
        while (f <= l) {
            res[f] = c;
            res[l] = c;
            f++;
            l--;
            c++;
        }
    }

}
