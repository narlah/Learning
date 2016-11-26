package archive;

import java.util.Scanner;

public class FindLetterIndexInAWord {
    private static final int TOTAL_LETTERS = 26;
    private static final int TOTAL_LETTERS_D = TOTAL_LETTERS * 2;
    private static char[] matrix = null;

    private static String readWord() {
        @SuppressWarnings("resource")
        Scanner r = new Scanner(System.in);
        while (true) {
            System.out.print("\nPlease enter a word and hit Enter : ");
            if (r.hasNextLine()) {
                String s = r.nextLine();
                if (!s.isEmpty())
                    return s;
            } else
                r.next();
        }
    }

    public static void fillAlphabetInArray() {
        int startCaps = 65;
        int startSubCaps = 97;
        for (int i = 0; i < TOTAL_LETTERS; i++) {
            matrix[i] = (char) startCaps++;
        }
        for (int i = TOTAL_LETTERS; i < TOTAL_LETTERS_D; i++) {
            matrix[i] = (char) startSubCaps++;
        }
    }

    public static void printArray() {
        for (int i = 0; i < TOTAL_LETTERS_D; i++) {
            System.out.print(" " + matrix[i]);
        }
    }

    public static void printCodesEasy(String word) {
        int wordLength = word.length();
        System.out.println("\n ---------Easy----------\n ");
        for (int i = 0; i < wordLength; i++) {
            char ch = word.charAt(i);
            for (int j = 0; j < TOTAL_LETTERS_D; j++) {
                if (matrix[j] == ch) {
                    System.out.printf("Char code for \"%s\" is %d.\n", ch, j);
                }
            }
        }
        System.out.println("\n --------------\n ");
    }

    public static void printCodesSmart(String word) {
        final int DISPLACEMENT = 6;
        int wordLength = word.length();
        System.out.println("\n -------Smart-------\n ");
        for (int i = 0; i < wordLength; i++) {
            char ch = word.charAt(i);
            int code = 0;
            if (ch == ' ') {
                code = (int) ch;
            } else {
                code = (int) ch - (int) ('A');
                if (Character.isLowerCase(ch)) {
                    code -= DISPLACEMENT;
                }
            }

            System.out.printf("Char code for \"%s\" is %d.\n", ch, code);
        }
        System.out.println("\n -------------------\n ");
    }

    public static void main(String[] args) {
        matrix = new char[TOTAL_LETTERS * 2]; //caps+lower case
        fillAlphabetInArray();
        printArray();
        String word = readWord();
        System.out.printf("\n Word : " + word);
        printCodesEasy(word);
        System.out.printf("\n Word : " + word);
        printCodesSmart(word);
        //Memo : Interval can be added to matrix or replaced with a custom code.
    }
}