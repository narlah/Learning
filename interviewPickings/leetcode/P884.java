package interviewPickings.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class P884 {
    public static void main(String[] args) {
        P884 z = new P884();
        System.out.println(Arrays.toString(z.uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    public String[] uncommonFromSentences(String A, String B) {
        HashSet<String> mapSum = new HashSet();
        HashSet<String> ignored = new HashSet();
        for (String word : (A + " " + B).split(" ")) {
            if (ignored.contains(word)) continue;
            if (mapSum.contains(word)) {
                mapSum.remove(word);
                ignored.add(word);
            } else
                mapSum.add(word);
        }
        return mapSum.toArray(new String[0]);
    }
}
