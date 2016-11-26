package archive;

public class HeadTailMaxConcurent {
    static int solution(int[] A) {
        int n = A.length;
        int initial = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                initial++;
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            int current = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    current++;
                else
                    current--;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    current++;
                else
                    current--;
            }
            r = Math.max(r, current);
        }
        return initial + r;
    }

    public static void main(String args[]) {

        System.out.println(solution(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0}));

    }
}
