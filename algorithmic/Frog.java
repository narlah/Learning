package algorithmic;

public class Frog {
    private static int numberOfWays(int n) {
        int prepre = 0, pre = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = pre + prepre;
            prepre = pre;
            pre = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Frog fr = new Frog();
        int lenghtToGo = 16;
        // fibonaci part
        long start = System.nanoTime();
        System.out.print("Fibo : " + numberOfWays(lenghtToGo));
        long elapsedTime = System.nanoTime() - start;
        System.out.println("  elapsed " + elapsedTime);

        // recursion part
        froggiRec frogy = fr.new froggiRec(lenghtToGo);
        long start2 = System.nanoTime();
        frogy.recNumberOfWays(0);
        System.out.print("recursion : " + frogy.ways);
        long elapsedTime2 = System.nanoTime() - start2;
        System.out.println(" elapsed " + elapsedTime2);

    }

    public class froggiRec {
        private int ways = 0;
        private int max = 0;

        froggiRec(int n) {
            max = n;
        }

        int recNumberOfWays(int current) {
            if (current > max)
                return 0;
            if (current == max) {
                ways++;
                return 0;
            }
            if (current < max) {
                recNumberOfWays(current + 1);
                recNumberOfWays(current + 2);
            }
            return 0;
        }
    }
}