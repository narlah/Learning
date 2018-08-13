package interviewPickings;


import tools.MatrixTools;

import java.util.LinkedList;
import java.util.Random;

public class Fill2dMatrixSorted {
    int[][] matrix;
    Random r = new Random();

    public void fillMatrix(int x, int y, int step) {
        LinkedList<Pair> order = new LinkedList<>();
        matrix = new int[x][y];
        matrix[0][0] = 1;
        order.push(new Pair(0, 0));
        while (order.size() > 0) {
            Pair p = order.pop();
            int currVal = matrix[p.i][p.j];
            if (p.i + 1 < x && matrix[p.i + 1][p.j] == 0) {
                matrix[p.i + 1][p.j] = currVal + r.nextInt(step) + 1;
                order.push(p.moveRight());
            }
            if (p.j + 1 < y && matrix[p.i][p.j + 1] == 0) {
                matrix[p.i][p.j + 1] = currVal + r.nextInt(step) + 1;
                order.push(p.moveDown());
            }
            if (p.j + 1 < y && p.i + 1 < x) {
                int diagonal = matrix[p.i + 1][p.j + 1];
                int right = matrix[p.i + 1][p.j];
                int down = matrix[p.i][p.j + 1];
                if (right > diagonal || down > diagonal) {
                    matrix[p.i + 1][p.j + 1] = Math.max(right, down) + 1;
                }
                order.push(p.moveDiagonal());
            }
        }
    }

    public static void main(String[] args) {
        Fill2dMatrixSorted ff = new Fill2dMatrixSorted();
        ff.fillMatrix(10, 10, 3);
        MatrixTools.printMatrix(ff.matrix, "---");
        int[] arr = new int[]{1, 11, 12, 13, 14, 48};
        for (int s : arr) {
            System.out.println(s + " : " + ff.findXInMatrix(ff.matrix, s));
        }
    }

    private String findXInMatrix(int[][] matrix, int searchFor) {
        int maxX = matrix.length - 1;
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < maxX && y >= 0) {
            int e = matrix[x][y];
            if (e == searchFor) {
                return formatXY(x, y);
            } else if (e > searchFor) {
                y = y - 1;
            } else {
                x = x + 1;
            }
        }
        return "false";
    }

    private String formatXY(int x, int y) {
        return "(" + x + "," + y + ")";
    }
}


class Pair {
    int i;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Pair moveRight() {
        return new Pair(this.i + 1, this.j);
    }

    public Pair moveDown() {
        return new Pair(this.i, this.j + 1);
    }

    public Pair moveDiagonal() {
        return new Pair(this.i + 1, this.j + 1);
    }
}