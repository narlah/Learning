package interviewPickings.codeFights;

import java.util.HashMap;

public class Cryptarihm {
    public static void main(String[] args) {
        Cryptarihm ccc = new Cryptarihm();
        String[] sss = new String[]{"SEND", "MORE", "MONEY"};
        char[][] solution = new char[][]{{'O', '0'},
                {'M', '1'},
                {'Y', '2'},
                {'E', '5'},
                {'N', '6'},
                {'D', '7'},
                {'R', '8'},
                {'S', '9'}};
        System.out.println(ccc.isCryptSolution(sss, solution));
    }

    boolean isCryptSolution(String[] crypt, char[][] solution) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char[] mapping : solution) {
            map.put(mapping[0], Character.getNumericValue(mapping[1]));
        }
        String word1 = calculateWordValue(crypt[0], map);
        String word2 = calculateWordValue(crypt[1], map);
        String resultWord = calculateWordValue(crypt[2], map);
        if (

                (word1.charAt(0) == '0' && word1.length() > 1) ||
                        (word2.charAt(0) == '0' && word2.length() > 1) ||
                        (resultWord.charAt(0) == '0' && resultWord.length() > 1)
                )
            return false;

        return Long.valueOf(word1) + Long.valueOf(word2) == Long.valueOf(resultWord);
    }

    String calculateWordValue(String word, HashMap<Character, Integer> map) {
        String res = "";
        for (char c : word.toCharArray()) {
            res += map.get(c);
        }
        return res;
    }

}
