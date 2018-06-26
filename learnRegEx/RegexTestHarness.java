package learnRegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args) {
//		String regex = "[a-f1-4&&[^fouy12]]";
        String regex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        String inputStringWeSearchInThisOne = "blqblqhttp://www.google.comkopeleeeeeeeeeeeeeetelnet://www.zamunda.netkopeleeeftp://www.nanja.tv";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStringWeSearchInThisOne);

        boolean found = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(String.format("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n", matcher.group(),
                    start, end));
            found = true;
        }
        if (!found) {
            System.out.println("No match found.");
        }
    }
}