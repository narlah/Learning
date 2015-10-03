package archive;
public class PrintATriangle {

	public static void main(String[] args) {
		// ***************************f6**********************************
		for (int i = -1; i < 9; i++) {
			if (i == -1) {
				System.out.printf("%12s\n", "*");
			} else {
				String formatLeft = "%" + (10 - i + 1) + "s";
				System.out.printf(formatLeft, "*");

				String formatRight = "%" + ((i + 1) * 2) + "s \n";
				System.out.printf(formatRight, "*");
			}

		}
		for (int i = 0; i < 11; i++) {
			System.out.print(" *");
		}

		// ***************************************************************

	}
}