package archive;

import tools.MatrixTools;

public class RotateAPicture90Degrees {
    private static int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    public static void main(String[] args) {
        MatrixTools.printMatrix(matrix, "Before");
        rotateMatrix();
        rotateMatrix();
        rotateMatrix();
        rotateMatrix();
        MatrixTools.printMatrix(matrix, "After");
    }

    private static void rotateMatrix() {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int n = matrix.length;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
