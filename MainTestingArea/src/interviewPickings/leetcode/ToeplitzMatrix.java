package interviewPickings.leetcode;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        ToeplitzMatrix tpz = new ToeplitzMatrix();
        int[][] matirx = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(tpz.isToeplitzMatrix(matirx));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int k = i, l = 0;
            int tmp = matrix[i][0];
            System.out.print(tmp + " - ");
            while (true) {
                k++;
                l++;
                if (k > m - 1 || l > n - 1) break;
                System.out.print(matrix[k][l] + " ");
                if (matrix[k][l] != tmp) return false;
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            int k = i, l = 0;
            int tmp = matrix[0][i];
            System.out.print(tmp + " - ");
            while (true) {
                k++;
                l++;
                if (k > n - 1 || l > m - 1) break;
                System.out.print(matrix[l][k] + " > ");
                if (matrix[l][k] != tmp) return false;
            }
            System.out.println();
        }
        return true;
    }
}
