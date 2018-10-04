package interviewPickings;

import java.util.List;

public class FindMaxSumSubArray {
    // DO NOT MODFIY THE LIST.
//    public int maxSubArray(List<Integer> C) {
//        int newsum = C.get(0);
//        int maxCurrent = C.get(0);
//        for (int i = 1; i < C.size(); i++) {
//            newsum = Math.max(newsum + C.get(i), C.get(i));
//            maxCurrent = Math.max(maxCurrent, newsum);
//        }
//        return maxCurrent;
//    }
    public int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int maxCurrent = nums[0];
        for (int i = 1; i < nums.length; i++) {
            newSum = Math.max(newSum + nums[i], nums[i]);
            maxCurrent = Math.max(maxCurrent, newSum);
        }
        return maxCurrent;
    }

    public static void main(String[] args) {
        FindMaxSumSubArray find = new FindMaxSumSubArray();
        System.out.println(find.maxSubArray(new int[]{25, -1, -1, -1, -1, 20, 2}));
    }
}
