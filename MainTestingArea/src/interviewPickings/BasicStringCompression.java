package interviewPickings;

public class BasicStringCompression {
    public static void main(String[] args) {
        BasicStringCompression main = new BasicStringCompression();
        // System.out.println(main.compressString("aabccccccdddddddddkkklzmpaaaaa"));
        String s = "aabcdejjjjjjjjjjjjjjjjjjjjjjjjjzza     a";
        String result = main.compressString(s);
        System.out.println();
        System.out.println(result + " - " + result.equals("2abcde25j2za5 a"));
        System.out.println(compress(s));
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

    public static String compress(String in) {
        if (in.length() < 3) return in;

        int n = in.length(), i = 0, o = 0;
        char[] out = new char[n + 1];
        out[o++] = in.charAt(0);
        out[o++] = '1';
        for (i = 1; i < n && o < n; i++) {
            if (in.charAt(i) == in.charAt(i - 1) && out[o - 1] != '9') {
                // Continued streak
                out[o - 1]++;
            } else {
                // New streak
                out[o++] = in.charAt(i);
                out[o++] = '1';
            }
        }
        return (i == n && o < n) ? new String(out, 0, o) : in;
    }
}
