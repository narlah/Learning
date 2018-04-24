package archive;

import java.util.HashMap;
import java.util.Map;

public class AreAnagrams {
    private static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length())
            return false;
        char[] charArrFirst = first.toCharArray();
        char[] charArrSecond = second.toCharArray();

        for (char firstCh : charArrFirst) {
            for (int i = 0; i < charArrSecond.length; i++) {
                if (firstCh == charArrSecond[i]) {
                    charArrSecond[i] = ' ';
                    break;
                }
            }
        }
        for (char ch : charArrSecond) {
            if (ch != ' ') {
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagrams2(String first, String second) {
        char[] word1 = first.toCharArray();
        char[] word2 = second.toCharArray();

        Map<Character, Integer> lettersInWord1 = new HashMap<>();

        for (char c : word1) {
            if (lettersInWord1.get(c) != null) {
                lettersInWord1.put(c, lettersInWord1.get(c) + 1);
            } else
                lettersInWord1.put(c, 1);
        }

        for (char c : word2) {
            lettersInWord1.put(c, lettersInWord1.get(c) - 1);
        }

        for (char c : lettersInWord1.keySet()) {
            if (lettersInWord1.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagramsPrime(String first, String second) {
        int[] primeAlphabet = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 113};
        long res1 = 1;
        for (char c : first.toCharArray()) {
            res1 *= c == ' ' ? primeAlphabet[26] : primeAlphabet[c - 'a'];
        }
        long res2 = 1;
        for (char c : second.toCharArray()) {
            res2 *= c == ' ' ? primeAlphabet[26] : primeAlphabet[c - 'a'];
        }
        return res1 == res2;
    }


    public static void main(String[] args) {
        String inanagram = "rail safety";
        String outanagram = "fairy tales";
        long long1 = System.nanoTime();
        System.out.println(areAnagrams(inanagram, outanagram));
        long long2 = System.nanoTime();
        double firstTime = long2 - long1;
        System.out.println("areAnagrams : " + firstTime);

        long long3 = System.nanoTime();
        System.out.println(areAnagrams2(inanagram, outanagram));
        long long4 = System.nanoTime();
        double secondTime = long4 - long3;
        System.out.println("areAnagrams2 (hash) : " + secondTime);

        System.out.println("Times slower : " + ((int) ((secondTime / firstTime) * 100)) / 100f + " times");


        long long5 = System.nanoTime();
        System.out.println(areAnagramsPrime(inanagram, outanagram));
        long long6 = System.nanoTime();
        double thirdTime = long6 - long5;
        System.out.println("areAnagramsPrime  : " + thirdTime);
        //wow that was pretty fucking fast ...
    }
}