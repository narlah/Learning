package hackerRank;

import java.util.SortedSet;
import java.util.TreeSet;

public class SmallestAndLargestKSubstring {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        int k = sc.nextInt();
        String line = "welcomeАААtojava";
        int k = 3;
        //int length = line.length();

        SortedSet<String> sets = new TreeSet<>();
        for (int i = 0; i <= line.length() - k; i++) {
            sets.add(line.substring(i, i + k));
        }
        System.out.println(sets.first());
        System.out.println(sets.last());
    }
//        int maxWindow;
//        int minWindow;
//        int smallestIndex = 0;
//        int largestIndex = 0;
//        if (length <= k) {
//            System.out.println(line);
//            System.out.println(line);
//            return;
//        }
//        int window = evaluateWindow(line, 0, k);
//        minWindow = window;
//        maxWindow = window;
//        for (int i = k; i < length - 1; i++) {
//            String str = line.substring(i - k, i);
//            int eval = evaluateWindow(line, i - k, k);
//            System.out.println(str + " " + eval);
//            char removed = line.charAt(i - k);
//            char added = line.charAt(i);
//
//            window = window - (int) line.charAt(i - k) + (int) line.charAt(i);
//            if (window > minWindow) {
//                smallestIndex = i - k + 1;
//                minWindow = window;
//            } else if (window < maxWindow) {
//                largestIndex = i - k + 1;
//                maxWindow = window;
//            }
//        }
//        System.out.println(line.substring(largestIndex, largestIndex + k));
//        System.out.println(line.substring(smallestIndex, smallestIndex + k));
//
//    }
//
//    private static int evaluateWindow(String line, int start, int k) {
//        int window = 0;
//        int remainingChars = line.length() - start;
//        int end = ((remainingChars >= k) ? k + start : remainingChars);
//        for (int j = start; j < end; j++) {
//            char c = line.charAt(j);
//            window += (int) c;
//        }
//        return window;
//    }
}
