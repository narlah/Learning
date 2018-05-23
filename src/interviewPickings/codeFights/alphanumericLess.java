package interviewPickings.codeFights;

public class alphanumericLess {

    public static void main(String[] args) {
        alphanumericLess alpha = new alphanumericLess();
        //System.out.println(alpha.alphanumericLess("ab000144", "ab000144x")); //true
        System.out.println(alpha.alphanumericLess("41", "14")); //false
    }

    boolean alphanumericLess(String s1, String s2) {

        String regex = "((?<=[a-zA-Z])(?<=[a-zA-Z]))|((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))";
        String[] wordOneArr = s1.split(regex);
        int word1Size = wordOneArr.length;
        String[] wordTwoArr = s2.split(regex);
        int word2Size = wordTwoArr.length;
        int maxSize = Math.max(word1Size, word2Size);
        for (int counter = 0; counter < maxSize; counter++) {
            if (counter == word1Size)
                return true;
            if (counter == word2Size)
                return false;
            String token1 = wordOneArr[counter];
            String token2 = wordTwoArr[counter];
            boolean isLetter1 = isLetter(token1);
            boolean isLetter2 = isLetter(token2);
            if (isLetter1 && isLetter2) {
                int compared = token1.compareTo(token2);
                if (compared < 0)
                    return true;
                else if (compared > 0) {
                    return false;
                }
            }
        }
        for (int counter = maxSize - 1; counter >= 0; counter--) {
            String token1 = wordOneArr[counter];
            String token2 = wordTwoArr[counter];
            boolean isLetter1 = isLetter(token1);
            boolean isLetter2 = isLetter(token2);
            if (!isLetter1 && !isLetter2) {
                double compared = Double.valueOf(token1) - Double.valueOf(token2);
                if (compared > 0) return false;
                else if (compared < 0) return true;
                else if (token1.length() == token2.length()) {
                    continue;
                } else if (token1.length() < token2.length()) {
                    return false;
                } else
                    return true;
            } else if (isLetter1) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    boolean isLetter(String s) {
        int charInt = s.charAt(0);
        if (s.length() > 1 || (charInt >= 48 && charInt <= 57))
            return false;

        return true;
    }

}
