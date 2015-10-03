package kosev;

public class ParseEquation {
	private static boolean parseIt(String s) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				counter++;
			}
			if (s.charAt(i) == ')') {
				if (counter > 0) {
					counter--;
				} else
					return false;
			}
		}
		return counter == 0 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(parseIt("(a+b+()(a-d)a)"));
	}
}
