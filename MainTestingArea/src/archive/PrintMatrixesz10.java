package archive;

import java.util.Scanner;

public class PrintMatrixesz10 {
    private static int[][] matrix = null;

    private static int readN() {
        @SuppressWarnings("resource")
        Scanner r = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter the number N : ");
            if (r.hasNextInt()) {
                int n = r.nextInt();
                if (n != 0)
                    return n;
            } else
                r.next();
        }
    }

    public static void fillMatrixVertical() {
        int n = matrix[0].length;
        int counter = n * n;
        for (int i = (n - 1); i >= 0; i--) {
            for (int j = (n - 1); j >= 0; j--) {
                matrix[j][i] = counter;
                counter--;
            }
        }
    }

    public static void fillMatrixVerticalAsync() {
        int n = matrix[0].length;
        int counter = 1;
        boolean directionDown = true;
        for (int col = 0; col < n; col++) {
            if (directionDown) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
            directionDown = !directionDown;
        }
    }

    public static void fillMatrixDiagonal() {
        int n = matrix[0].length;
        int counter = 1;
        //lower left part + main diagonal from 0,0
        for (int i = n - 1, times = 1; i >= 0; i--, times++) {
            for (int diag = 0; diag < times; diag++) {
                matrix[i + diag][diag] = counter;
                counter++;
            }
        }
        //upper right part without the main diagonal
        for (int i = 0, times = n - 1; i < n - 1; i++, times--) {
            for (int diag = 1; diag <= times; diag++) {
                matrix[diag - 1][i + diag] = counter;
                counter++;
            }
        }
    }

    public static void fillMatrixDiagonalT() {
        int n = matrix[0].length;
        int counter = 1;
        //lower left part + main diagonal from 0,0
        for (int i = n - 1, times = 1; i >= 0; i--, times++) {
            for (int diag = 0; diag < times; diag++) {
                matrix[diag][i + diag] = counter;
                counter++;
            }
        }
        //upper right part without the main diagonal
        for (int i = 0, times = n - 1; i < n - 1; i++, times--) {
            for (int diag = 1; diag <= times; diag++) {
                matrix[i + diag][diag - 1] = counter;
                counter++;
            }
        }
    }

    public static void printMatrix(String name) {
        int n = matrix[0].length;
        if (n > 0) {
            System.out.printf("\n The filled matrix follows %s: \n ", name);
            for (int i = 0; i < n; i++) {
                System.out.println();
                for (int j = 0; j < n; j++)
                    System.out.format("%4d", matrix[i][j]);
            }
        } else {
            System.out.println("The matrix is not initialized!");
        }
        System.out.println("\n -------------------\n ");
    }

    public static void main(String[] args) {
        int n = readN();
        System.out.println("N:" + n);
        matrix = new int[n][n];

        fillMatrixVertical();
        printMatrix("����������");

        fillMatrixVerticalAsync();
        printMatrix("���������� � �������� �� ��������");

        fillMatrixDiagonal();
        printMatrix("����������");

        fillMatrixDiagonalT();
        printMatrix("���������� �������������");

        matrix = new int[n][n];
        SpiralFilling.fillMatrixInASpirall();
        printMatrix("�������");
    }

    static class SpiralFilling {
        static int n = matrix[0].length;
        static int counter = 1;
        static int direction = 0;
        static int positionX = -1, positionY = 0;

        public static void fillMatrixInASpirall() {

            for (int moveCounter = 0; moveCounter < n; moveCounter++) {
                move();
            }
            direction = (direction + 1) % 4;
            while (counter <= n * n) {
                for (int timesMove = n - 1; timesMove > 0; timesMove--) {
                    for (int moveCounter = 1; moveCounter <= timesMove; moveCounter++) {
                        move();
                    }
                    direction = (direction + 1) % 4;
                    for (int moveCounter = 1; moveCounter <= timesMove; moveCounter++) {
                        move();
                    }
                    direction = (direction + 1) % 4;
                }
            }
        }

        private static void move() {
            switch (direction) {
                case 0:
                    matrix[++positionX][positionY] = counter++; // down
                    break;
                case 1:
                    matrix[positionX][++positionY] = counter++; // right
                    break;
                case 2:
                    matrix[--positionX][positionY] = counter++; // up
                    break;
                case 3:
                    matrix[positionX][--positionY] = counter++; // left
                    break;
            }
        }
    }
}