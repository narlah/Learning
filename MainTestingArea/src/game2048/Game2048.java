package game2048;
public class Game2048 {
	public static final int SIZE_MIN = 3;
	public static final int MOVE_LEFT = 1;
	public static final int MOVE_RIGHT = 2;
	public static final int MOVE_UP = 4;
	public static final int MOVE_DOWN = 8;

	public final int size;
	public final int goal;
	final int[] board;
	private boolean gameOver;
	private boolean won;
	private int[] stack;
	private int stackPointer;
	private boolean skipNextSum;

	public Game2048(int size, int goal) {
		if (size < SIZE_MIN) {
			throw new IllegalArgumentException("board size cannot be smaller than " + SIZE_MIN);
		}
		if (goal < 0) {
			throw new IllegalArgumentException("goal must be positive");
		}
		this.size = size;
		this.goal = goal;
		board = new int[size * size];
		stack = new int[size];
		newGame();
	}

	void setBoard(int[] newBoard) {
		int s = Math.min(newBoard.length, board.length);
		for (int i = 0; i < s; i++) {
			board[i] = newBoard[i];
		}
	}

	public void getBoard(int[] newBoard) {
		int s = Math.min(newBoard.length, board.length);
		for (int i = 0; i < s; i++) {
			newBoard[i] = board[i];
		}
	}

	public void newGame() {
		// clear Board
		for (int i = 0, l = board.length; i < l; i++) {
			board[i] = 0;
		}
		// random 2 free numbers in the board
		addRandomTile();
		addRandomTile();

		// start game
		gameOver = false;
		won = false;

	}

	private void addRandomTile() {
		// count free tiles
		int freeTiles = 0;
		for (int i = 0, l = board.length; i < l; i++) {
			if (board[i] == 0) {
				freeTiles++;
			}
		}
		if (freeTiles <= 0) {
			if (!tileMatchesAvailable()) {
				gameOver = true;
			}
		} else {
			int tile = (int) (RND.generate() * freeTiles);
			int value = RND.generate() < 0.9 ? 2 : 4;

			// set the value
			freeTiles = 0;
			for (int i = 0, l = board.length; i < l; i++) {
				if (board[i] == 0) {
					if (freeTiles == tile) {
						board[i] = value;
					}
					freeTiles++;
				}
			}
			freeTiles--;
			if (freeTiles <= 0) {
				if (!tileMatchesAvailable()) {
					gameOver = true;
				}
			}
		}
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean isWon() {
		return won;
	}

	public boolean cellsAvailable() {
		for (int i = 0, l = board.length; i < l; i++) {
			if (board[i] == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean tileMatchesAvailable() {
		for (int y = 0, ym = board.length - size; y < ym; y += size) {
			for (int x = 0, xm = size - 1; x < xm; x++) {
				int cell = y + x;
				if (board[cell] == board[cell + 1]) {
					return true;
				}
				if (board[cell] == board[cell + size]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean movesAvailable() {
		return cellsAvailable() || tileMatchesAvailable();
	}

	private boolean isRowEmpty(int offset) {
		for (int x = 0; x < size; x++) {
			if (board[offset++] != 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isColumnEmpty(int offset) {
		for (; offset < board.length; offset += size) {
			if (board[offset] != 0) {
				return false;
			}
		}
		return true;
	}

	private void clearStack() {
		for (int i = 0; i < size; i++) {
			stack[i] = 0;
		}
		stackPointer = 0;
		skipNextSum = false;
	}

	private void pushStack(int value) {
		if (value <= 0) {
			// nothing to store
			return;
		}
		if (stackPointer == 0 || skipNextSum) {
			stack[stackPointer++] = value;
			skipNextSum = false;
			return;
		}
		final int current = stackPointer - 1;
		if (stack[current] == value) {
			stack[current] <<= 1;
			if (stack[current] >= goal) {
				won = true;
			}
			skipNextSum = true;
		} else {
			stack[stackPointer++] = value;
			skipNextSum = false;
		}
	}

	boolean doRowLeft(int offset) {
		boolean changed = false;
		clearStack();
		for (int x = offset, l = offset + size; x < l; x++) {
			pushStack(board[x]);
		}
		for (int x = offset, l = offset + size, s = 0; x < l; x++) {
			if (board[x] != stack[s]) {
				changed = true;
			}
			board[x] = stack[s++];
		}
		return changed;
	}

	boolean moveLeft() {

		// try left shift
		boolean changed = false;

		// for each row try shift if there are empties
		for (int y = 0, ym = board.length - size; y <= ym; y += size) {
			if (!isRowEmpty(y)) {
				changed |= doRowLeft(y);
			}
		}
		return changed;
	}

	boolean doRowRight(int offset) {
		boolean changed = false;
		clearStack();
		for (int x = offset + size - 1; x >= offset; x--) {
			pushStack(board[x]);
		}
		for (int x = offset + size - 1, s = 0; x >= offset; x--) {
			if (board[x] != stack[s]) {
				changed = true;
			}
			board[x] = stack[s++];
		}
		return changed;
	}

	boolean moveRight() {
		// try left shift
		boolean changed = false;

		// for each row try shift if there are empties
		for (int y = 0, ym = board.length - size; y <= ym; y += size) {
			if (!isRowEmpty(y)) {
				changed |= doRowRight(y);
			}
		}
		return changed;
	}

	boolean doColumnUp(int column) {
		boolean changed = false;
		clearStack();
		for (int x = column, i = 0; i < size; i++, x += size) {
			pushStack(board[x]);
		}
		for (int x = column, i = 0, s = 0; i < size; i++, x += size) {
			if (board[x] != stack[s]) {
				changed = true;
			}
			board[x] = stack[s++];
		}
		return changed;
	}

	boolean moveUp() {
		// try left shift
		boolean changed = false;

		// for each row try shift if there are empties
		for (int y = 0; y < size; y++) {
			if (!isColumnEmpty(y)) {
				changed |= doColumnUp(y);
			}
		}
		return changed;
	}

	boolean doColumnDown(int column) {
		boolean changed = false;
		clearStack();
		for (int x = column + size * (size - 1); x >= 0; x -= size) {
			pushStack(board[x]);
		}
		for (int x = column + size * (size - 1), s = 0; x >= 0; x -= size) {
			if (board[x] != stack[s]) {
				changed = true;
			}
			board[x] = stack[s++];
		}
		return changed;
	}

	boolean moveDown() {
		// try left shift
		boolean changed = false;

		// for each row try shift if there are empties
		for (int y = 0; y < size; y++) {
			if (!isColumnEmpty(y)) {
				changed |= doColumnDown(y);
			}
		}
		return changed;
	}

	public void doMove(int move) {
		if (gameOver) {
			return;
		}
		boolean changed = false;

		switch (move) {
		case MOVE_LEFT:
			changed = moveLeft();
			break;
		case MOVE_RIGHT:
			changed = moveRight();
			break;
		case MOVE_UP:
			changed = moveUp();
			break;
		case MOVE_DOWN:
			changed = moveDown();
			break;
		}

		if (changed) {
			addRandomTile();
		}
	}

}
