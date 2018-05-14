package archive;

import tools.MatrixTools;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotateAPicture90Degrees {


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        MatrixTools.printMatrix(matrix, "Before");
        RotateAPicture90Degrees rotate = new RotateAPicture90Degrees();
        //rotate.rotateMatrix(matrix);
        //rotate.rotateMatrix(matrix);
        //rotate.rotateMatrix(matrix);
        rotate.rotateMatrix(matrix);
        MatrixTools.printMatrix(matrix, "After");

    }

    private void rotateMatrix(int[][] matrix) {
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

    private ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> matrix) {
        double size = matrix.size();
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - i - 1; j++) {
                int n = (int) size;
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(n - j - 1).get(i));
                matrix.get(n - j - 1).set(i, matrix.get(n - i - 1).get(n - j - 1));
                matrix.get(n - i - 1).set(n - j - 1, matrix.get(j).get(n - i - 1));
                matrix.get(j).set(n - i - 1, temp);
            }
        }
        return matrix;
    }

//    public ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> a) {
//        int[][] mat = new int[a.size()][a.size()];
//        for (int i = 0; i < a.size(); i++) {
//            mat[0] = a.get(i).stream().mapToInt(j -> j).toArray();
//        }
//        rotateMatrix(mat);
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < a.size() ; i++) {
//            res.add((ArrayList)IntStream.of(mat[0][i]).boxed().collect(Collectors.toList()));
//        }
//        return res;
//    }


}
