package interviewPickings.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum trsum = new ThreeSum();
        //int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));

        List<List<Integer>> result = trsum.threeSum(arr);
        System.out.println();
        result.forEach(s -> System.out.println(Arrays.toString(s.toArray())));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length - 1;
        for (int i = 0; i <= n - 2; i++) {
            int j = i + 1;
            int k = n;

            while (k > j) {
                int z = (nums[i] + nums[j] + nums[k]);
                if (z == 0) {
                    ArrayList r1 = new ArrayList(3);
                    r1.add(nums[i]);
                    r1.add(nums[j]);
                    r1.add(nums[k]);
                    result.add(r1);
                }
                if (z > 0)
                    k--;
                else
                    j++;
            }
        }
        return result.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }
}
