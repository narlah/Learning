package interviewPickings.hackerRank;

import java.util.HashMap;

public class RansomNote {
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> h1 = new HashMap<>();
        for (String s : magazine)
            h1.merge(s, 1, Integer::sum);

        for (String n : note) {
            if (h1.containsKey(n) && h1.get(n) >= 1) {
                h1.merge(n, -1, Integer::sum);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        String s1 = "give me one grand today night";
        String s2 = "give one grand today";
        checkMagazine(s1.split(" "), s2.split(" "));
    }
}
