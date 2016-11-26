import java.util.HashSet;

public class MarkAllRowsAndCollsIfThereIsZeroSomeWhere {
    private static int[][] matrix = {{1, 1, 1, 1, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}};

    public static void main(String[] args) {

        MarkAllRowsAndCollsIfThereIsZeroSomeWhere main = new MarkAllRowsAndCollsIfThereIsZeroSomeWhere();
        printMatrix("before", matrix);
        main.cleanRowsCollsWhereZeroExists(matrix);
        printMatrix("after", matrix);
    }

    private void cleanRowsCollsWhereZeroExists(int[][] matrixIn) {
        HashSet<Integer> hashX = new HashSet<Integer>();
        HashSet<Integer> hashY = new HashSet<Integer>();
        for (int i = 0; i < matrixIn.length; i++) {
            if (hashX.contains(i))
                continue;
            for (int j = 0; j < matrixIn[0].length; j++) {
                if (matrixIn[i][j] == 0) {
                    hashX.add(i);
                    hashY.add(j);
                    break;
                }
            }
        }
        for (int i : hashX) {
            for (int j = 0; j < matrixIn[0].length; j++) {
                matrixIn[i][j] = 0;
            }

        }
        for (int j : hashY) {
            for (int i = 0; i < matrixIn.length; i++) {
                matrixIn[i][j] = 0;
            }
        }

    }

    private static void printMatrix(String name, int[][] matrix) {
        if (matrix.length > 0) {
            System.out.printf("\n The filled matrix follows %s: \n ", name);
            for (int i = 0; i < matrix.length; i++) {
                System.out.println();
                for (int j = 0; j < matrix[0].length; j++)
                    System.out.format("%4d", matrix[i][j]);
            }
        } else {
            System.out.println("The matrix is not initialized!");
        }
        System.out.println("\n -------------------\n ");
    }

}
