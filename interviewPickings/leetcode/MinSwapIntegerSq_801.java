package interviewPickings.leetcode;
//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/solution/
//total fail , one must TODO learn Dynamic Programming

import java.util.Arrays;

public class MinSwapIntegerSq_801 {

    public static void main(String[] args) {
        MinSwapIntegerSq_801 minSwapC = new MinSwapIntegerSq_801();
        int[] A = new int[]{1, 3, 5, 4};
        int[] B = new int[]{1, 2, 3, 7};


        System.out.println(Arrays.toString(A) + " <-> " + Arrays.toString(B) + "   result should be 1 : " + minSwapC.minSwap(A, B));
    }

    //    public int minSwap(int[] A, int[] B) {
//        // n: natural, s: swapped
//        int n1 = 0, s1 = 1;
//        for (int i = 1; i < A.length; ++i) {
//            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
//            if (A[i-1] < A[i] && B[i-1] < B[i]) {
//                n2 = Math.min(n2, n1);
//                s2 = Math.min(s2, s1 + 1);
//            }
//            if (A[i-1] < B[i] && B[i-1] < A[i]) {
//                n2 = Math.min(n2, s1);
//                s2 = Math.min(s2, n1 + 1);
//            }
//            n1 = n2;
//            s1 = s2;
//        }
//        return Math.min(n1, s1);
//    }
    public int minSwap(int[] A, int[] B) {
        int swaps = 0;
        int end = A.length - 1;
        for (int i = 1; i < end; i++) {
            if ((A[i] > B[i - 1] && A[i] < B[i + 1] && B[i] > A[i - 1] && B[i] < A[i + 1])) {
                System.out.println(i);
                int tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
                swaps++;
            }
        }
        if (A[0] > A[1] || B[0] > B[1]) {
            int tmp = A[0];
            A[0] = B[0];
            B[0] = tmp;
            swaps++;
        }

        if (A[end] < A[end - 1] || B[end] < B[end - 1]) {
            int tmp = A[end];
            A[end] = B[end];
            B[end] = tmp;
            swaps++;
        }
        return swaps;
    }
}
