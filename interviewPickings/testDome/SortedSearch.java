package interviewPickings.testDome;

import java.util.Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int lo = 0, hi = sortedArray.length;
        if (sortedArray[hi - 1] < lessThan) return hi;
        if (hi == 0) return 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sortedArray[mid] < lessThan)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo % sortedArray.length;
    }

    public static int countNumbersBuildIn(int[] sortedArray, int lessThan) {
        if (sortedArray.length == 0) return 0;
        if (sortedArray[0] >= lessThan) return 0;

        int num = Arrays.binarySearch(sortedArray, lessThan);
        if (num >= 0) {
            return num;
        }
        return (-num) - 1;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{-3, -2, -1, 1, 2, 3, 3, 4, 4, 12, 56, 78, 100}, 100));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{1, 3, 5, 7}, 4));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{0}, 0));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{1, 2, 3}, 4));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{1, 2, 3}, 0));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{5, 7, 12}, 11));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{0, 1, 5, 6, 44, 55, 99, 101}, 100));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{5, 6, 7, 9, 10}, 7));
        System.out.println(SortedSearch.countNumbersBuildIn(new int[]{6, 7, 8}, 7));
    }
}
