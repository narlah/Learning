package interviewPickings.leetcode;

import java.util.ArrayList;

public class P868 {

    public static void main(String[] args) {
        P868 p = new P868();
        System.out.println(p.binaryGap(8));
    }

    public int binaryGap(int N) {
        char[] representation = Integer.toBinaryString(N).toCharArray();
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < representation.length; i++) {
            if (representation[i] == '1')
                indexes.add(i);
        }
        int max = 0;
        int l = 0;
        while (l + 1 < indexes.size()) {
            max = Math.max(max, indexes.get(l + 1) - indexes.get(l));
            l++;
        }
        return max;
    }
}
