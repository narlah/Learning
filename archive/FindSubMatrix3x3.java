package archive;

import tools.MatrixTools;

import java.util.Scanner;

public class FindSubMatrix3x3 {
    private static int[][] matrix = null;
    private static int n = 0;
    private static int m = 0;

    private static int readNM(String str) {
        @SuppressWarnings("resource")
        Scanner r = new Scanner(System.in);
        while (true) {
            System.out.printf("\nPlease enter the number %s : ", str);
            if (r.hasNextInt()) {
                int n = r.nextInt();
                if (n != 0 & n >= 3)
                    return n;
            } else
                r.next();
        }
    }

    private static void fillMatrixVertical() {
        int counter = n * m;
        for (int i = (n - 1); i >= 0; i--) {
            for (int j = (m - 1); j >= 0; j--) {
                matrix[i][j] = counter;
                counter--;
            }
        }
    }


    private static int sum3x3(int x, int y) {

        return matrix[x][y] + matrix[x][y + 1] + matrix[x][y + 2] + matrix[x + 1][y]
                + matrix[x + 1][y + 1] + matrix[x + 1][y + 2] + matrix[x + 2][y] + matrix[x + 2][y + 1]
                + matrix[x + 2][y + 2];
    }

    private static int[] findAndPrintMax3x3() {
        int sum = 0;
        int x = 0, y = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                int result = sum3x3(i, j);
                if (sum < result) {
                    x = i;
                    y = j;
                    sum = result;
                }
            }
        }
        return new int[]{sum, x, y};
    }

    public static void main(String[] args) {
        n = readNM("N");
        m = readNM("M");
        System.out.println("N:" + n);
        System.out.println("M:" + m);
        matrix = new int[n][m];
        fillMatrixVertical();
        MatrixTools.printMatrix(matrix, "\"For testing purposes\"");
        int[] result = findAndPrintMax3x3();
        System.out.println("Maxsimal 3x3 minor is : " + result[0] + "positions:[" + result[1] + "," + result[2] + "]");
    }
}