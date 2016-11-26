package archive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestCommonElements {
    final static int[] arr1 = {4, 7, 3, 9, 2};
    final static int[] arr2 = new int[10000000];

    static {
        Arrays.fill(arr2, 100);
    }

    public static void testOne() {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    //System.out.println(arr1[i]);
                }
            }
        }
    }

    public static void testTwo() {
        // List<Integer> list = Arrays.asList(arr1);
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int n : arr1) {
            hashSet.add(n);
        }
        for (int j = 0; j < arr2.length; j++) {
            if (hashSet.contains(arr2[j])) {
                //System.out.println(arr1[j]);
            }
        }
    }

    public static void main(String a[]) {
        long time = System.nanoTime();
        testOne();
        long time2 = System.nanoTime();
        System.out.println(time2 - time);

        long time1 = System.nanoTime();
        testTwo();
        long time3 = System.nanoTime();
        System.out.println(time3 - time1);

    }

}
