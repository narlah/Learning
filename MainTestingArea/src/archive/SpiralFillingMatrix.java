package archive;

//import java.util.Scanner;

public class SpiralFillingMatrix {
	private static int[][] matrix = null;
	private static int currentDir = 0;
	private static int currentNumber = 0;

//	private static int readConsoleForN() {
//		Scanner scanReader = new Scanner(System.in);
//		while (true) {
//			System.out.print("Please enter N (1-30): ");
//			if (scanReader.hasNextInt()) {
//				int n = scanReader.nextInt();
//				if (n != 0 & n <= 30) {
//					return n;
//				} else {
//					System.out.println("Nope, out of bounds, try again!");
//				}
//			} else {
//				System.out.println("Nope,not an int, try again!");
//				scanReader.next();
//			}
//		}
//	}

	public static void printMatrix() {
		int n = matrix[0].length;
		if (n > 0) {
			System.out.println("\n The filled matrix follows : ");
			for (int i = 0; i < n; i++) {
				System.out.println();
				for (int j = 0; j < n; j++)
					System.out.format("%4d", matrix[i][j]);
			}
		} else {
			System.out.println("The matrix is not initialized!");
		}
	}

	// Main recurs. method
	private static void move(int x, int y) {
		int n = matrix[0].length;

		if (x < 0 || x >= n || y < 0 || y >= n || // exits matrix bounds
				matrix[x][y] > 0) {// matrix already filled at this coordinates
			currentDir = (currentDir + 1) % 4; // we cycle the 4 directions
			return;
		}

		matrix[x][y] = currentNumber;
		currentNumber -= 1;
		if (currentNumber <= 0) { // we finished the filling
			System.out.printf("Circled to Zero  at : x is %d :y is %d \n", x, y);
			return;
		}
		int tempDir = 0;
		do {
			tempDir = currentDir;
			stepOver(x, y);
		} while (tempDir != currentDir && currentNumber != 0);

	}

	private static void stepOver(int x, int y) {
		switch (currentDir) {
		case 0:
			move(x - 1, y); // up
			break;
		case 1:
			move(x, y - 1); // left
			break;
		case 2:
			move(x + 1, y); // down
			break;
		case 3:
			move(x, y + 1); // right
			break;
		}
	}

	public static void main(String[] args) { // rename to fillMatrix in a
		// outside class
		//		int n = readConsoleForN();
		for (int n = 1; n <= 10; n++) {
			System.out.println("\n\n**************** " + n + " **************** ");
			currentDir = 0;
			matrix = new int[n][n];
			currentNumber = n * n - 1;
			// Ensures we start on the correct corner of the array
			if (n % 2 == 0) { // even
				move(0, 0); // upper left corner is a start
			} else { // odd
				move(n - 1, n - 1); // bottom right corner is start
			}
			printMatrix();

		}
	}
}