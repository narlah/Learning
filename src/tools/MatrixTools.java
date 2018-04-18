package tools;

public class MatrixTools {
    public static void printMatrix(int[][] matrix, String name) {
        int n = matrix.length;
        if (n > 0) {
            int m = matrix[0].length;
            System.out.printf("\n The filled matrix with name %s : \n ", name);
            for (int i = 0; i < n; i++) {
                System.out.println();
                for (int j = 0; j < m; j++)
                    System.out.format("%4d", matrix[i][j]);
            }
        } else {
            System.out.println("The matrix is not initialized!");
        }
        System.out.println("\n \n ");
    }
}
