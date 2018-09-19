package interviewPickings.hackerRank;

import java.util.Arrays;
import java.util.HashMap;

public class MinimalSwaps {

    static int minimumSwaps(int[] arr) {
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            int correctValue = arr2[i];
            int whereActuallyItIs = map.get(correctValue);
            if (i != whereActuallyItIs) {
                int tmp = arr[i];
                arr[i] = correctValue;
                arr[whereActuallyItIs] = tmp;

                map.put(correctValue, i);
                map.put(tmp, whereActuallyItIs);
                swap++;
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 8}));
    }
}
