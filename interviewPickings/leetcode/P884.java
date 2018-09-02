package interviewPickings.leetcode;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class P884 {
    public static void main(String[] args) {
        P884 z = new P884();
        System.out.println(Arrays.toString(z.uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    public String[] uncommonFromSentences(String A, String B) {
        String[] arr = (A + " " + B).split(" ");
        return Arrays.stream(arr).collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).collect(Collectors.toList())
                .stream().toArray(String[]::new); //size -> new String[size]

        //67ms vs 5ms for the one bellow - sometimes simplicity is better !

//        HashSet<String> mapSum = new HashSet();
//        HashSet<String> ignored = new HashSet();
//        for (String word : (A + " " + B).split(" ")) {
//            if (ignored.contains(word)) continue;
//            if (mapSum.contains(word)) {
//                mapSum.remove(word);
//                ignored.add(word);
//            } else
//                mapSum.add(word);
//        }
//         return mapSum.toArray(new String[0]);
    }
}
