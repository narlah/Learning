package archive;

public class convertStringToInt {

	public static int convertStringToIntVal(String num) {
		int result = 0;
		int zeroAscii = 48;
		int nineAscii = 57;
		for (char c : num.toCharArray()) {
			if (c >= zeroAscii && c <= nineAscii) {
				result = result * 10 + (c - zeroAscii);
			} else
				return -1;
		}
		return result;
	}

	public static void main(String[] args) {
		// ***************************f6**********************************
		System.out.println(convertStringToIntVal("12131477") + 1);
		// ***************************************************************
	}
}
// ***************************************************************
// System.out.println(Runtime.getRuntime().availableProcessors());
// ***************************************************************
