package minesweeper;

public class MineFieldSquare {
	private boolean bomb = false;
	private boolean flagged = false;
	private boolean alreadyOpened = false;
	private int nearbyBombsNumber = 0;

	public int getNearbyBombsNumber() {
		return nearbyBombsNumber;
	}

	public void setNearbyBombsNumber(int nearbyBombsNumber) {
		this.nearbyBombsNumber = nearbyBombsNumber;
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public boolean isAlreadyOpened() {
		return alreadyOpened;
	}

	public void setAlreadyOpened(boolean alreadyOpened) {
		this.alreadyOpened = alreadyOpened;
	}

}
