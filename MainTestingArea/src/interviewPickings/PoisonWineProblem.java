package interviewPickings;
//1000 bottles of wine, one poisoned
//10 tester rats
// one try to find it
//clearly binary search something O (log(n))


import java.util.Arrays;

public class PoisonWineProblem {

    public static void main(String[] args) {
        PoisonWineProblem pwp = new PoisonWineProblem();
        final int total = 1000;
        boolean[] wine = new boolean[total];
        for (int i = 1; i <= 10; i++) {
            int step = (int) Math.pow(2, i);
            for (int j = 1; j < total; j += step) {
                wine[j] = true;
            }
        }
        System.out.println(Arrays.toString(wine));
    }
}
