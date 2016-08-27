package minesweeper;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main {
	private static final int MATRIX_DIMENSION = 10;
	private static final int BUTTON_SIZE = 23;
	private JFrame frame;
	private JTextField editTime;
	private JTextField editMarkedMines;
	private MatrixRepresentation matrix = new MatrixRepresentation(MATRIX_DIMENSION);
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnRestartGame = new JButton("Go");
		btnRestartGame.setBounds(219, 0, 80, 23);
		frame.getContentPane().add(btnRestartGame);

		editTime = new JTextField();
		editTime.setEditable(false);
		editTime.setBounds(142, 417, 86, 20);
		frame.getContentPane().add(editTime);
		editTime.setColumns(10);

		editMarkedMines = new JTextField();
		editMarkedMines.setEditable(false);
		editMarkedMines.setBounds(368, 417, 86, 20);
		frame.getContentPane().add(editMarkedMines);
		editMarkedMines.setColumns(10);

		createMineFieldPanel();
		fillZeMinefieldPanel();
		addMassOpenButton();
	}

	private void createMineFieldPanel() {
		panel = new JPanel();
		panel.setBounds(10, 21, 535, 385);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	}

	private void fillZeMinefieldPanel() {

		for (int i = 0; i < MATRIX_DIMENSION; i++) {
			for (int j = 0; j < MATRIX_DIMENSION; j++) {
				JButtonMineField newButton = createNewButton(i, j);
				panel.add(newButton);
			}
		}
	}

	private JButtonMineField createNewButton(int i, int j) {
		JButtonMineField newButton = new JButtonMineField("", i, j);
		int positionX = 36 + BUTTON_SIZE * i;
		int positionY = 30 + BUTTON_SIZE * j;
		newButton.setBounds(positionX, positionY, BUTTON_SIZE, BUTTON_SIZE);
		addMouseListenerForMineCleanerClicks(newButton);
		return newButton;
	}

	private void addMouseListenerForMineCleanerClicks(JButtonMineField newButton) {
		newButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseClickedEvent) {
				JButtonMineField button = (JButtonMineField) mouseClickedEvent.getSource();
				int i = button.getI();
				int j = button.getJ();
				if (SwingUtilities.isLeftMouseButton(mouseClickedEvent))
					leftMouseButtonClicked(button, i, j);
				if (SwingUtilities.isRightMouseButton(mouseClickedEvent)) {
					rightMouseButtonClicked();
				}
			}

			private void leftMouseButtonClicked(JButtonMineField button, int i, int j) {
				if (!matrix.isAlreadyOpened(i, j)) {
					matrix.setSquareOpened(i, j);
					button.setEnabled(false);
					if (matrix.isBombXY(i, j)) {
						setBombIcon(button, i, j);
						System.out.println("kaboom");
					} else {
						int bombCount = matrix.getNearbyBombsCount(i, j);
						button.setToolTipText(bombCount + "");
						System.out.println("nearby bombs : " + bombCount);
					}

				} else {
					//System.err.println(matrix.isAlreadyOpened(i, j));
				}
			}

			private void rightMouseButtonClicked() {
				System.out.println("Do nothing at the moment");
			}

			private void setBombIcon(JButtonMineField button, int i, int j) {
				if (matrix.isBombXY(i, j))
					button.setIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose-pressed.gif")));
			}
		});
	}

	private void addMassOpenButton() {
		JButton btnMassopen = new JButton("MassOpen");
		btnMassopen.setBounds(317, 0, 115, 23);
		frame.getContentPane().add(btnMassopen);

		btnMassopen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseClickedEvent) {
				for (Component comp : panel.getComponents()) {
					((JButton) comp).mouseDown(mouseClickedEvent.get, 10, 10);
					((JButton) comp).mouseUp(mouseClickedEvent, 10, 10);
				}
			}
		});
	}
}
