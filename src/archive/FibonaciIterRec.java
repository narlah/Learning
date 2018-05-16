package archive;
import java.math.BigInteger;
public class FibonaciIterRec {

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static long fibonacciIter(int n) {
        if (n < 2) {
            return n;
        } else {
            long sum = 0;
            long nMinus1 = 1;
            long nMinus2 = 1;
            for (int i = 2; i < n; i++) {
                sum = nMinus1 + nMinus2;
                nMinus2 = nMinus1;
                nMinus1 = sum;

            }
            return sum;
        }
    }

    public static double fibonaciFormula(int n) {
        double sqrt5 = Math.sqrt(5);
        return (1 / sqrt5) * Math.pow((1 + sqrt5) / 2, n) - (1 / sqrt5) * Math.pow(((1 - sqrt5) / 2), n);
    }

//    public static String fibonaciFormula(int n, int k) {
//        if (n < k) {
//            return "1";
//        }
//        double sqrt5 = Math.sqrt(5);
//        BigInteger f = new BigInteger("0");
//        BigInteger s = new BigInteger("0");
//        f = Math.pow((1 + sqrt5) / k, n);
//        s = Math.pow(((1 - sqrt5) / k), n);
//        return BigInteger ((1 / sqrt5) *  - (1 / sqrt5) * );
//    }


    public static void main(String[] args) {
        // ***************************f6**********************************
        //long t1 = System.nanoTime();
        //System.out.println(fibonacci(1000));
       // long t2 = System.nanoTime();
        //System.out.println("Time takes for iterative : " + (t2 - t1));
        long i1 = System.nanoTime();
        System.out.println(fibonacciIter(48));
        long i2 = System.nanoTime();
        System.out.println("Time takes for iterative : " + (i2 - i1));
        System.out.println((int) fibonaciFormula(48));
        // ***************************************************************
    }
}
// ***************************************************************
// System.out.println(Runtime.getRuntime().availableProcessors());
// ***************************************************************
