package archive;

import java.util.HashSet;

public class RemoveDuplicatesInAString {

	public static void main(String[] args) {
		String str = new String("eeeeefggkkoss  aaaszz   asd       j2qqa");
		StringBuilder strBuild = new StringBuilder(250); // we assume max 250 symbols
		HashSet<Character> hashSet = new HashSet<Character>();
		for (char c : str.toCharArray()) {
			if (hashSet.contains(c)) {
				continue;
			} else {
				hashSet.add(c);
				strBuild.append(c);
			}
		}

		System.out.println(strBuild.toString());

	}

}
