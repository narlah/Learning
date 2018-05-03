package interviewPickings.codefights;

/* Provided a string, your mission is to find and count all set (of indices) of characters of that the sum of their ASCII is equal to 237.

Examples

    For str = "Hello world!", the output should be
    str237(str) = 1.
    Here is the ascii values or the above string:
    72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33.
    From the above list, we can only obtain one set of character which has the ascii sum is 237: H d! (237 = 72 + 32 + 100 + 33).
    So the final answer is: 1

    For str = "Hello world!!", the output should be
    str237(str) = 2.
    You have 2 sets H d!. So, the answer is 2.
 */
public class ChallengeStr237 {

    public static void main(String[] args) {
        ChallengeStr237 cha = new ChallengeStr237();
        System.out.println(cha.str237("https://www.youtube.com/watch?v=mN0zPOpADL4"));
    }

    int str237(String str) {
//        int n = str.length();
//        int count = 0;
//        int[] arr = new int[n];
//        char[] charArr = str.toCharArray();
//        for (int i = 0; i < n; i++) {
//            arr[i] = charArr[i];
//        }
//        System.out.println(arr.length);
//        long N = (long) Math.pow(2d, Double.valueOf(n));
//        for (int i = 1; i < N; i++) {
//            String code = Long.toBinaryString(N | i).substring(1);
//            int val = 0;
//            for (int j = 0; j < n; j++) {
//                if (code.charAt(j) == '1') {
//                    val += arr[j];
//                    if (val > 237)
//                        break;
//                }
//            }
//            if (val == 237)
//                count++;
//        }
//        return count;

    }
    public static int GetCombinations(int[] set, String values, int count ) {
        for (int i = 0; i < set.length; i++) {
            int left = 237 - set[i];
            if (left == 0) {
                count++;
            } else {
                int[] possible = System.arraycopy(set, i,);
                if (possible.Length > 0) {
                    foreach (string s in GetCombinations(possible, left, vals)) {
                        yield return s;
                    }
                }
            }
        }
    }
}
