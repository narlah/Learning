package interviewPickings.codeFights;

public class GreedyDecoding {
    public static void main(String[] args) {
        GreedyDecoding g = new GreedyDecoding();
        System.out.println(g.greedyDecoding("195318520"));
    }

    String greedyDecoding(String message) {
        int counter = message.length();
        char[] charArr = message.toCharArray();
        int l = 0;
        StringBuilder sb = new StringBuilder();
        while (l < counter) {
            if (counter - l == 1) {
                sb.append((char) (16 + charArr[l]));
                break;
            }
            int n = Integer.valueOf(charArr[l] + "" + charArr[l + 1]);
            if (n < 27) {
                sb.append((char) (64 + n));
                l += 2;
            } else {
                sb.append((char) (16 + charArr[l]));
                l += 1;
            }
        }
        return sb.toString();
    }


}
