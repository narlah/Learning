package parserTurtle;

import java.util.StringTokenizer;

public class ParseCommands {

	public static Command parseCommand(String line) {
		StringTokenizer st = new StringTokenizer(line);
		Character command = st.nextToken().charAt(0);

		int number = 0;
		if (st.hasMoreElements()) {
			String numberToken = st.nextToken();
			if (checkLenght(numberToken))
				number = new Integer(numberToken);
		}
		assert (number >= 0);
		assert (!st.hasMoreTokens());

		return new Command(command, number);
	}

	private static boolean checkLenght(String str) {
		return str.length() >= 1 ? true : false;
	}
}
