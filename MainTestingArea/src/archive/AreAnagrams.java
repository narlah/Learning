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

    public static void main(String[] args) {
        String inanagram = "momdad govoril kokobokojokodokomuuu kokobokojokodokomuuu kokobokojokodokomuuu";
        String outanagram = "dadmom govolir kokookomuuubokojokod kokobokojokodokomuuu kokobokojokodokomuuu";
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
        System.out.println("Times slower : " + (secondTime / firstTime) * 100 + "%");

    }
}