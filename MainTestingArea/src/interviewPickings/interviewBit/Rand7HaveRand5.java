package interviewPickings.interviewBit;


import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.function.IntSupplier;

public class Rand7HaveRand5 {
    static Random r = new Random();

    public static void main(String[] args) {
        testProbabilities(Rand7HaveRand5::rand5);
        testProbabilities(Rand7HaveRand5::rand7);
        testProbabilities(Rand7HaveRand5::implementRand7With5);
        testProbabilities(Rand7HaveRand5::theirSolution);

    }

    private static void testProbabilities(IntSupplier function) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            Integer a = function.getAsInt();
            if (hash.containsKey(a.intValue())){
                hash.put(a,hash.get(a)+1);
            } else
                hash.put(a,1);
        }
        System.out.println(Collections.singletonList(hash));
    }

    private static int rand5(){
        return r.nextInt(5)+1;
    }

    private static int rand7(){
        return r.nextInt(7)+1;
    }

    private static int implementRand7With5(){
        int  res = rand5();
        if (res>2)
            return rand5()+2;
        else
            return res;
    }

    public static int theirSolution() {

        while (true) {

            // do our die rolls
            int roll1 = rand5();
            int roll2 = rand5();

            int outcomeNumber = (roll1-1) * 5 + (roll2-1) + 1;

            // if we hit an extraneous
            // outcome we just re-roll
            if (outcomeNumber > 21) continue;

            // our outcome was fine. return it!
            return outcomeNumber % 7 + 1;
        }
    }


}
