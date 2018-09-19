package interviewPickings.leetcode;

public class FlipInvert_832 {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            flipInvert(A, i);
        }
        return A;
    }

    public void flipInvert(int[][] A, int i) {
        int l = 0;
        int r = A[i].length - 1;
        while (l < r) {
            if (A[i][l] == A[i][r]) {
                A[i][l] ^= 1;
                A[i][r] ^= 1;
            }
            l++;
            r--;
        }
        if (l == r) {
            A[i][l] ^= 1;
        }
    }

    public int[][] flipAndInvertImageOfficial(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}
