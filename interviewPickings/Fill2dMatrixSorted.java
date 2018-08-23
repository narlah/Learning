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
            System.out.println(s + " : " + ff.findXInMatrixLinear(ff.matrix, s));
        }

        for (int s : arr) {
            ff.findXInMatrixBSearch(ff.matrix, s);
            //System.out.println(s + " : " + ff.findXInMatrixBSearch(ff.matrix, s));
        }
    }

    private void findXInMatrixBSearch(int[][] matrix, int searchFor) {
        int maxX = matrix.length - 1;
        int maxY = matrix[0].length - 1;
        //return recBSearch(matrix, 0,maxY, 0 , maxX, searchFor);
        searchOfficial(matrix, 0, maxY, 0, maxX, searchFor);

    }

    private String recBSearch(int[][] arr, int fromCol, int toCol, int fromRow, int toRow, int searchFor) {
        String res = "";
        int midCol = fromCol + (toCol - fromCol) / 2;
        int midRow = fromRow + (toRow - fromRow) / 2;
        int midVal = arr[midCol][midRow];
        if (midVal == searchFor) {
            return "Found at " + midCol + " " + midRow;
        }
        if (midRow != toRow && midCol != toCol)
            res += recBSearch(arr, fromCol, midCol, midRow, toRow, searchFor);
        if (midVal > searchFor && midRow - 1 >= fromCol) {
            res += recBSearch(arr, fromCol, toCol, fromRow - 1, midRow, searchFor);
        } else if (midCol + 1 <= toRow) { // midVal < searchFor
            res += recBSearch(arr, midCol + 1, toCol, fromRow, toRow, searchFor);
        }
        return res;
    }


    public static void searchOfficial(int[][] mat, int fromRow, int toRow,
                                      int fromCol, int toCol, int key) {
        // Find middle and compare with middle
        int midCol = fromCol + (toCol - fromCol) / 2;
        int midRow = fromRow + (toRow - fromRow) / 2;
        int midVal = mat[midRow][midCol];
        if (midVal == key) // If key is present at middle
            System.out.println("Found " + key + " at " + midRow +
                    " " + midCol);
        else {
            // right-up quarter of matrix is searched in all cases.
            // Provided it is different from current call
            if (midRow != toRow || midCol != fromCol)
                searchOfficial(mat, fromRow, midRow, midCol, toCol, key);

            // Special case for iteration with 1*2 matrix
            // mat[midRow][midCol] and mat[midRow][midCol+1] are only two elements.
            // So just check second element
            if (fromRow == toRow && fromCol + 1 == toCol)
                if (mat[fromRow][toCol] == key)
                    System.out.println("Found " + key + " at " +
                            fromRow + " " + toCol);

            // If middle key is lesser then search lower horizontal
            // matrix and right hand side matrix
            if (midVal < key) {
                // search lower horizontal if such matrix exists
                if (midRow + 1 <= toRow)
                    searchOfficial(mat, midRow + 1, toRow, fromCol, toCol, key);
            }

            // If middle key is greater then search left vertical
            // matrix and right hand side matrix
            else {
                // search left vertical if such matrix exists
                if (midCol - 1 >= fromCol)
                    searchOfficial(mat, fromRow, toRow, fromCol, midCol - 1, key);
            }
        }
    }

    private String findXInMatrixLinear(int[][] matrix, int searchFor) {
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