package ODXadvancedJavaConcepts;

public class StringSubsequences {
    public static String subsequences(String word) {
        if (word.isEmpty()) {
            return ""; // base case
        } else {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);

            String subsequencesOfRest = subsequences(restOfWord);

            String result = "";
            for (String subsequence : subsequencesOfRest.split(",", -1)) {
                result += "," + subsequence;
                result += "," + firstLetter + subsequence;
            }
            result = result.substring(1); // remove extra leading comma
            return result;
        }
    }

    /**
     * Return all subsequences of word (as defined above) separated by commas,
     * with partialSubsequence prepended to each one.
     */
    private static String subsequencesAfter(String partialSubsequence, String word) {
        if (word.isEmpty()) {
            // base case
            return partialSubsequence;
        } else {
            // recursive step
            return subsequencesAfter(partialSubsequence, word.substring(1))
                    + ","
                    + subsequencesAfter(partialSubsequence + word.charAt(0), word.substring(1));
        }
    }

    public static String subsequencesA(String word) {
        return subsequencesAfter("", word);
    }

    public static void main(String[] args) {
        String word = "abcdehfg";
        //System.out.println(StringSubsequences.subsequences(word).substring(1));
        System.out.println(StringSubsequences.subsequencesA(word));
    }
}
