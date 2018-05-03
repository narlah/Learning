package interviewPickings.codeFights;

import java.util.Arrays;

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
        System.out.println(cha.str237("here is question Write a method that generates an int array as a parameter, converts the generated integers into characters and print the new char array. Array values should be in the range [0 -255]. could not convert integer to ASCII co"));
    }

    int str237(String str) {
        int n = str.length();
        int count = 0;
        int[] arr = new int[n];
        char[] charArr = str.toCharArray();
        for (int i = 0; i < n; i++) {
            arr[i] = charArr[i];
        }
        Arrays.sort(arr);

        return isSubsetSum(arr, n, 237, count);


    }

    static int isSubsetSum(int set[], int n, int sum, int count) {
        // Base Cases
        if (sum == 0)
            return ++count;
        if (n == 0 && sum != 0)
            return 0;

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum, count);

       /* else, check if sum can be obtained by any of the following
          (a) including the last element
          (b) excluding the last element   */
        return count + isSubsetSum(set, n - 1, sum, count) + isSubsetSum(set, n - 1, sum - set[n - 1], count);
    }
/*
        prev version
        craptastic , after 30 elements its just not feasible , better learn proper dynamic programming ffs
        int n = str.length();
        int count = 0;
        int[] arr = new int[n];
        char[] charArr = str.toCharArray();
        for (int i = 0; i < n; i++) {
            arr[i] = charArr[i];
        }
        System.out.println(arr.length);
        long N = (long) Math.pow(2d, Double.valueOf(n));
        for (int i = 1; i < N; i++) {
            String code = Long.toBinaryString(N | i).substring(1);
            int val = 0;
            for (int j = 0; j < n; j++) {
                if (code.charAt(j) == '1') {
                    val += arr[j];
                    if (val > 237)
                        break;
                }
            }
            if (val == 237)
                count++;
        }
        return count;
 */
}
