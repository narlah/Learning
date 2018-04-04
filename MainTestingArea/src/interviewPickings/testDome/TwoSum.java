package interviewPickings.testDome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] findTwoSum_fail(int[] list, int sum) {
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            int indexSearched = Arrays.binarySearch(list, sum - list[i]);
            if (indexSearched >= 0 && list[i] != sum / 2. && indexSearched != i) {
                return new int[]{i, indexSearched};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] z = new int[]{0, 3, 5, 7, 13};
        int sum = 12;

        int[] indices = findTwoSum(z, sum);
        int[] indices2 = findTwoSum_fail(z, sum);
        if (indices != null) {
            System.out.println(Arrays.toString(indices) + " " + Arrays.toString(indices2));
        }
    }
}