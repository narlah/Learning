package archive;


public class ReverseStringInplace {
	public static void main(String[] args) throws InterruptedException {
		String stringToReverse = "Клиентът ни търси човек, който да заема в дългосрочен план длъжността „Java Developer”, като компанията изисква от кандидата предишен опит с Java(минимум 2 години), както и много добро ниво на Английски език (писмено и говоримо).";

		StringBuilder strBuild = new StringBuilder();
		for (String word : reverseStringTailForward(stringToReverse).split(" ")) {
			strBuild.append(reverseStringTailForward(word));
			strBuild.append(" ");
		}
		System.out.println(strBuild.toString());

	}

	// private static String reverseStringWhole(String str) {
	// char[] charArray = str.toCharArray();
	// int i = 0, j = charArray.length - 1;
	// while (i < j) {
	// char t = charArray[i];
	// charArray[i] = charArray[j];
	// charArray[j] = t;
	// i++;
	// j--;
	// }
	// return String.valueOf(charArray);
	// }

	private static String reverseStringTailForward(String str) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			strBuilder.append(str.charAt(i));
		}
		return strBuilder.toString();
	}
}