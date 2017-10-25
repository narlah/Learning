package interviewPickings.interviewBit;


import java.util.Random;
import java.util.function.IntSupplier;

public class Rand7HaveRand5 {
    static Random r = new Random();

    public static void main(String[] args) {
        testProbabilities(Rand7HaveRand5::rand5, 5);
        testProbabilities(Rand7HaveRand5::rand7, 7);
        testProbabilities(Rand7HaveRand5::implementRand7With5, 7);
        testProbabilities(Rand7HaveRand5::theirSolution, 7);

    }

    private static void testProbabilities(IntSupplier function, int arraySize) {
        int[] arr = new int[arraySize];
        for (int i = 0; i < 10000; i++) {
            Integer a = function.getAsInt();
            arr[a - 1] = arr[a - 1] + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arraySize; i++) {
            sb.append(i + 1 + " = " + arr[i] + "  ");
        }
        System.out.println(sb.toString());
    }

    private static int rand5() {
        return r.nextInt(5) + 1;
    }

    private static int rand7() {
        return r.nextInt(7) + 1;
    }

    private static int implementRand7With5() {
        int res = rand5();
        if (res > 2)
            return rand5() + 2;
        else
            return res;
    }

    private static int theirSolution() {

        while (true) {

            // do our die rolls
            int roll1 = rand5();
            int roll2 = rand5();

            int outcomeNumber = (roll1 - 1) * 5 + (roll2 - 1) + 1;

            // if we hit an extraneous
            // outcome we just re-roll
            if (outcomeNumber > 21) continue;

            // our outcome was fine. return it!
            return outcomeNumber % 7 + 1;
        }
    }


}
