package archive;
import java.lang.StringBuilder;

public class UpcaseEndUpcase {

	public static void main(String[] args) {
		// ***************************f6**********************************
		String str = new String(
				"We are living in a <upcase>yellow submarine</upcase>. We don't have anything else. Inside the submarine is very tight. So we are <upcase>drinking</upcase> all the day. We <upcase>will</upcase> move out of it in 5 days.");
		String searchForStart = "<upcase>";
		String searchForEnd = "</upcase>";
		StringBuilder strBuild = new StringBuilder(str.length());
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				char c = str.charAt(i + 1);
				if (c == 'u') {
					i = i + searchForStart.length() - 1;
					flag = true;
					continue;
				}
				if (c == '/') {
					i = i + searchForEnd.length() - 1;
					flag = false;
					continue;
				}
			}
			strBuild.append(flag ? Character.toUpperCase(str.charAt(i)) : str.charAt(i));

		}
		System.out.println(strBuild.toString());
	}
	// ***************************************************************
}

// ***************************************************************
//while (index < str.length()) {
//	int posStart = index + str.substring(index).indexOf(searchForStart);
//	int endIndex = posStart + searchForStart.length();
//	System.out.println( endIndex+ "  -> "+ str.substring(endIndex)+ "--\n" );
//	int posEnd = endIndex
//			+ str.substring(index + posStart + searchForStart.length()).indexOf(searchForEnd);
//	if (posStart != -1 & posEnd != -1) {
//		String soFar = str.substring(index, posStart);
//		String toUpperCaseSection = str.substring(posStart + searchForStart.length(), posEnd);
//		strBuild.append(soFar).append(toUpperCaseSection.toUpperCase());
//		index = posEnd + index + searchForEnd.length();
//	} else {
//		break;
//	}
//}
// ***************************************************************
