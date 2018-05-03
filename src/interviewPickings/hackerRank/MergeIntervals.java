package interviewPickings.hackerRank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeIntervals {

    public static void main(String[] args) {
        ArrayList<Integer[]> userProvided = new ArrayList<>();
//        Scanner in = new Scanner(System.in);
//        int input = in.nextInt();
//
//        for (int i = 0; i < input ; i++) {
//            int f = in.nextInt();
//            int s = in.nextInt();
//            userProvided.add(new Integer[]{f, s});
//        }
        userProvided.add(new Integer[]{1, 3});
        userProvided.add(new Integer[]{2, 6});
        userProvided.add(new Integer[]{8, 10});
        userProvided.add(new Integer[]{15, 18});
        int input = 4;
        if (userProvided.size() < 2) {
            System.out.println(0);
            return;
        }
        userProvided.sort(Comparator.comparingInt((Integer[] a) -> a[0]));
        //System.out.println("sorted " + Arrays.deepToString(userProvided.toArray()));
        //sorted [[11.0, 13.45], [11.15, 12.13], [13.0, 15.0], [14.0, 18.4]]

        PriorityQueue<Integer> minEndTimes = new PriorityQueue<>();
        minEndTimes.offer(userProvided.get(0)[1]);
        for (int i = 1; i < userProvided.size(); i++) {
            if (userProvided.get(i)[0] <= minEndTimes.peek()) {
                minEndTimes.poll();
                input--;
            }
            minEndTimes.offer(userProvided.get(i)[1]);
        }
        System.out.println(input);

    }
}
