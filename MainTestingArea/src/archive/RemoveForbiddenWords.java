package archive;


//Make another version that would streamline the process - get a word, check in the array - replace if needed.
//Current solution would NOT be efficient (i think) if the text is too large - we create a new string every time we use replaceAll

import java.util.Arrays;

public class RemoveForbiddenWords {

    public static void main(String[] args) {
        // ***************************f6**********************************
        String str = new String(
                "Microsoft announced its next generation Java compiler today.It uses advanced parser and special optimizer for the Microsoft JVM.");
        String forbiddenWords = "Java,JVM,Microsoft";
        String[] forbiddenWordsArray = forbiddenWords.split(",");

        String s1 = new String(str);
        String s2 = new String(str);
        for (String word : forbiddenWordsArray) {
            String filled = create_Word(word.length(), '*');
            s1 = s1.replaceAll(word, filled);
//			s2 = s2.replaceAll("\\b" + word + "\\b", filled);

        }
        System.out.println(s1);
        System.out.println(s2);
    }

    // ***************************************************************
    private static String create_Word(int length, char charToFill) {
        if (length > 0) {
            char[] array = new char[length];
            Arrays.fill(array, charToFill);
            return new String(array);
        }
        return "";
    }
}
