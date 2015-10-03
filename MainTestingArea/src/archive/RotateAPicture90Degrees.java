package archive;
public class RotateAPicture90Degrees {
	private static int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

	public static void main(String[] args) {
		printMatrix("before", matrix);
		rotateMatrix();
		rotateMatrix();
		rotateMatrix();
		rotateMatrix();
		printMatrix("after", matrix);
	}

	private static void rotateMatrix() {
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - i-1; j++) {
				int n = matrix.length;
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}

	private static void printMatrix(String name, int matrix[][]) {
		int n = matrix.length;
		int m = matrix[0].length;
		if (n > 0 || m > 0) {
			System.out.printf("\n The filled matrix follows '%s': \n", name);
			for (int i = 0; i < n; i++) {
				System.out.println();
				for (int j = 0; j < m; j++)
					System.out.format("%4d", matrix[i][j]);
			}
		} else {
			System.out.println("The matrix is not initialized!");
		}
		System.out.println("\n -------------------\n ");
	}

}
