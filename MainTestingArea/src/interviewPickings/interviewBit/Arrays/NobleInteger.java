package interviewPickings.interviewBit.Arrays;
/*
    Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
    If such an integer is found return 1 else return -1.
*/

public class NobleInteger {
    public static void main(String[] args) {
        NobleInteger n = new NobleInteger();
        //int[] arr = new int[]{ -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };
        int[] arr = new int[]{6, 1};
        System.out.println(n.solve(arr));
    }

    public int solve(int[] A) {
        java.util.Arrays.sort(A);
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int elem = A[i];
            if (elem == len - i - 1) {
                if ((elem == 0 && i == len - 1) || (i + 1 <= len - 1 && A[i + 1] > elem)) {
                    //(elem == 0 && i == len - 1)  - corner case - zero is last number in array
                    // (i + 1 <= len - 1 && A[i + 1] > elem) - in case we have duplicates
                    return 1;
                }
            }
        }

        return -1;
    }

}
