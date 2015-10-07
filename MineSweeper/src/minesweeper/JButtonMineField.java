package minesweeper;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonMineField extends JButton {
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	private int i = 0;
	private int j = 0;

	public JButtonMineField(String inputDefaultString, int i, int j) {
		super(inputDefaultString);
		this.i = i;
		this.j = j;

	}

}
