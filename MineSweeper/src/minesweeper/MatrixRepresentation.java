package minesweeper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixRepresentation {
	private int matrixSize = 10;
	private int countMines = 0;
	private MineFieldSquare[][] mineField = new MineFieldSquare[matrixSize][matrixSize];

	public MatrixRepresentation(int size) {
		if (size < 0 || size > 20) {
			throw new IllegalArgumentException("Size out of bounds : " + size);
		}
		this.matrixSize = size;
		initializeMatrixField();
	}

	public int countMinesLeft() {
		return countMines;
	}

	public boolean isBombXY(int x, int y) {
		checkXYInput(x, y);
		return mineField[x][y].isBomb();
	}

	public boolean isAlreadyOpened(int x, int y) {
		checkXYInput(x, y);
		return mineField[x][y].isAlreadyOpened();
	}

	public int getNearbyBombsCount(int x, int y) {
		return mineField[x][y].getNearbyBombsNumber();
	}

	public void setSquareOpened(int x, int y) {
		checkXYInput(x, y);
		mineField[x][y].setAlreadyOpened(true);
	}

	private void checkXYInput(int x, int y) {
		if (x < 0 || x > matrixSize || y < 0 || y > matrixSize) {
			throw new IllegalArgumentException("xy out of bounds " + x + " " + y);
		}
	}

	private void initializeMatrixField() {
		autoPopulateMatrixWithNewCells();
		int counterNewMines = 0;
		Random rand = new Random();

		while (counterNewMines < matrixSize) {
			int i = rand.nextInt(matrixSize);
			int j = rand.nextInt(matrixSize);
			if (!mineField[i][j].isBomb()) {
				mineField[i][j].setBomb(true);
				counterNewMines++;
			}
		}
		countMines = counterNewMines;
		autoPopulateMatrixNearbyBombs();
	}

	private void autoPopulateMatrixWithNewCells() {
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				mineField[i][j] = new MineFieldSquare();
			}
		}
	}

	class coords {
		coords(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x = 0;
		int y = 0;
	}

	private void autoPopulateMatrixNearbyBombs() {

		final List<coords> array = Arrays.asList(new coords(1, 0), new coords(0, 1), new coords(-1, 0), new coords(0, -1), new coords(1, 1),
				new coords(-1, -1), new coords(1, -1), new coords(-1, 1));

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				int count = 0;
				for (coords xyCoords : array) {
					count += checkCellForBomb(i + xyCoords.x, j + xyCoords.y);
				}
				mineField[i][j].setNearbyBombsNumber(count);
			}
		}
	}

	private int checkCellForBomb(int x, int y) {
		if (x < 0 || x >= matrixSize || y < 0 || y >= matrixSize) {
			return 0;
		} else {
			return mineField[x][y].isBomb() ? 1 : 0;
		}
	}
}
