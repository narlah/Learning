package interviewPickings.interviewBit;

import java.util.Arrays;

public class WaveArray {
    public int[] wave(int[] A) {
        if (A.length < 2) return A;
        Arrays.sort(A);
        for (int i = 0; i < A.length ; i=i+2) {
            if (i+1>=A.length) break;
            int t = A[i];
            A[i] = A[i + 1];
            A[i + 1] = t;
        }
        return A;
    } // 01 (3) 34

    public static void main(String[] args) {
        WaveArray waveClass = new WaveArray();
        int[] arr = {11, 8, 7, 9, 2, 10, 2 };

        System.out.println(Arrays.toString(waveClass.wave(arr)));
    }
}


