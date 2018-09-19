package interviewPickings.leetcode;

import java.util.*;
import java.util.function.Function;

public class DegreeOfAnArray_697 {

    public static void main(String[] args) {
        DegreeOfAnArray_697 dg = new DegreeOfAnArray_697();
        System.out.println(dg.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, int[]> minMaxPos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
                minMaxPos.put(nums[i], new int[]{i, i});
            } else {
                freq.put(nums[i], freq.get(nums[i]) + 1);
                int[] r = minMaxPos.get(nums[i]);
                r[1] = i;
                minMaxPos.put(nums[i], r);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(freq.entrySet());
        list.sort(Comparator.comparing((Function<Map.Entry<Integer, Integer>, Integer>) Map.Entry::getValue).reversed());
        int max = list.get(0).getValue();
        int minLen = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : list) {
            if (e.getValue() < max)
                break;
            int[] nArr = minMaxPos.get(e.getKey());
            minLen = Math.min(minLen, nArr[1] - nArr[0] + 1);
        }
        return minLen;
    }
}
