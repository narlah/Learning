package interviewPickings;

import tools.MatrixTools;

import java.util.HashSet;

public class MarkAllRowsAndCollsIfThereIsZeroSomeWhere {
    private static int[][] matrix = {{1, 1, 1, 1, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}};

    public static void main(String[] args) {

        MarkAllRowsAndCollsIfThereIsZeroSomeWhere main = new MarkAllRowsAndCollsIfThereIsZeroSomeWhere();
        MatrixTools.printMatrix(matrix, "before");
        main.cleanRowsCollsWhereZeroExists(matrix);
        MatrixTools.printMatrix(matrix, "after");
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

}
