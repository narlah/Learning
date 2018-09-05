package algorithmic;

import java.util.Arrays;

public class FindKthLargestElementQuickSelectAlgo {

    public static void main(String[] args) {
        int[] array = {1, 8, 5, 11, 12, 19, 3, 44, 87}; // 11 is the median
        System.out.println(Arrays.stream(array).sum() / array.length);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
