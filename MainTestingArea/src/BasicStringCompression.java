public class BasicStringCompression {
    public static void main(String[] args) {
        BasicStringCompression main = new BasicStringCompression();
        // System.out.println(main.compressString("aabccccccdddddddddkkklzmpaaaaa"));
        System.out.println(main.compressString("abcdejjjjjjjjjjjjjjjjjjjjjjjjjzza     a"));
    }

    private String compressString(String string) {
        if (string.length() == 0)
            return string;
        StringBuilder builder = new StringBuilder();
        char currChar = string.charAt(0);
        int currentCount = 0;
        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (currChar == ch[i])
                currentCount++;

            if (currChar != ch[i] || i == ch.length - 1) {
                if (currentCount >= 2)
                    builder.append(currentCount).append("").append(currChar);
                else
                    builder.append(currChar);

                if (i == ch.length - 1 && ch[i] != currChar) {
                    builder.append(ch[i]);
                }
                currentCount = 1;
                currChar = ch[i];
            }
        }
        return string.length() == builder.length() ? string : builder.toString();
    }
}
