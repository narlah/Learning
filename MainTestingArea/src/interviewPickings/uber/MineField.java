package interviewPickings.uber;

import java.util.Arrays;

public class MineField {
    static int[][] arr = new int[][]{
            {0, 0, 0, 1, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0}
    };
    public final int[][] dirs = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {1, -1},
            {1, 1},
            {-1, -1},
            {-1, 1},
            {0, -1}
    };

    private int[][] returnMatrix(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    int x, y;
                    for (int[] coef : dirs) {
                        x = i + coef[0];
                        y = j + coef[1];
                        if (x >= arr.length || y >= arr[0].length || x < 0 || y < 0)
                            break;
                        result[x][y] = result[x][y] + 1;
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
