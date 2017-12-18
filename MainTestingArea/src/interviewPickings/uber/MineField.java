package interviewPickings.uber;

import java.util.Arrays;

public class MineField {
    static int[][] arr = new int[][]{
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0}
    };
    public final int[][] dirs = new int[][]{
            {1, 0},
            {0, 1},
            {1, 1},
            {-1, -1},
            {1, -1},
            {-1, 1},
            {-1, 0},
            {0, -1}
    };

    private int[][] returnMatrix(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];

        for (int y = 0; y < arr[0].length; y++) {
            for (int x = 0; x < arr.length; x++) {
                if (arr[y][x] == 1) {
                    int a, b;
                    for (int[] coef : dirs) {
                        a = x + coef[0];
                        b = y + coef[1];
                        if (a >= arr.length || b >= arr[0].length || a < 0 || b < 0)
                            continue;
                        result[b][a] = result[b][a] + 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MineField m = new MineField();

        System.out.println(Arrays.deepToString(m.returnMatrix(arr)));
    }

}
