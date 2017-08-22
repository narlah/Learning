package interviewPickings;

public class BasicStringCompression {
    public static void main(String[] args) {
        BasicStringCompression main = new BasicStringCompression();
        // System.out.println(main.compressString("aabccccccdddddddddkkklzmpaaaaa"));
        String result = main.compressString("abcdejjjjjjjjjjjjjjjjjjjjjjjjjzza     a");
        System.out.println();
        System.out.println(result + " - " + result.equals("abcde25j2za5 a"));
    }

    private String compressString(String string) {
        if (string.length() == 0)
            return string;

        StringBuilder builder = new StringBuilder();
        char[] ch = string.toCharArray();
        char currChar = ch[0];
        int currentCount = 1;

        for (int i = 1; i < ch.length; i++) {
            if (currChar == ch[i]) {
                currentCount++;
            } else {
                if (currentCount > 1)
                    builder.append(currentCount);
                builder.append(currChar);

                if (i == ch.length - 1 && ch[i] != currChar) {
                    builder.append(ch[i]);
                }
                currentCount = 1;
                currChar = ch[i];
            }
        }
        return builder.toString();
    }
}
