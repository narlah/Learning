package interviewPickings;

import java.util.*;

public class CountNumberOfSubArraysSumToZero {
/*
    We can use MultiMap  to print all sub-arrays with 0 sum present in the given array.
    The idea is to create an empty multimap to store ending index of all sub-arrays having given sum.
    We traverse the given array, and maintain sum of elements seen so far.
    If sum is seen before, there exists at-least one sub-array with 0 sum which ends at current index and we print all such sub-arrays.
*/

    public static void main(String[] args) {
        //int[] arr = new int[]{2, -2, 0};
        //int[] arr = new int[]{3, 2, -2, 0, 2, -2, 2};
        int[] arr = new int[]{2, -2, 3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        System.out.println("mine : " + printAllSubArrays(arr) + "\n");
        System.out.println("theirs : " + printAllSubArraysOfficial(arr));
    }

    private static int printAllSubArrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0, sum = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum))
                counter += map.get(sum);
            map.merge(sum, 1, Integer::sum);
        }
        return counter;

    }

    // Function to print all sub-arrays with 0 sum present in the given array
    public static int printAllSubArraysOfficial(int[] A) {
        int counter = 0;
        // create an empty Multi-map to store ending index of all
        // sub-arrays having same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // sub-array with 0 sum starts from index 0
        insert(hashMap, 0, -1);

        int sum = 0;

        // traverse the given array
        for (int i = 0; i < A.length; i++) {
            // sum of elements so far
            sum += A[i];

            // if sum is seen before, there exists at-least one
            // sub-array with 0 sum
            if (hashMap.containsKey(sum)) {
                List<Integer> list = hashMap.get(sum);

                // find all sub-arrays with same sum
                for (Integer value : list)
                    System.out.print("[" + printIt(A, value + 1, i) + "]\n");
                counter += list.size();
            }

            // insert (sum so far, current index) pair into the Multi-map
            insert(hashMap, sum, i);
        }
        return counter;
    }

    private static String printIt(int[] A, int start, int end) {
        StringJoiner s = new StringJoiner("+");
        for (int i = start; i <= end; i++) {
            s.add(" " + A[i] + " ");
        }
        return s.toString();
    }

    //Utility function to insert <key, value> into the Multimap //sadly merge not working here
    private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }
}
