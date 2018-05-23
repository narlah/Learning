package interviewPickings.codeFights;

import java.math.BigInteger;
import java.util.ArrayList;

public class Kbonaci {
    public static void main(String[] args) {
        Kbonaci kb = new Kbonaci();
        System.out.println(kb.kbonacci(2, 6));
        System.out.println(kb.JoroKbonacci(10, 65));
    }


    public String kbonacci(int k, int n) {
        if (n < k) {
            return "1";
        }
        ArrayList<BigInteger> arr = new ArrayList<>(k+1);
        for (int i = 0; i < k; i++) {
            arr.add(new BigInteger("1"));
        }

        BigInteger res = new BigInteger(k+ "");
        arr.add(new BigInteger(k + ""));
        for (int z = 0; z < n - k ; z++) {
            res = res.subtract(arr.get(0)).add(arr.get(arr.size()-1));
            arr.remove(0);
            arr.add(res);
        }
        return res.toString();
    }

    public String JoroKbonacci(int k, int n) {
        final BigInteger one = new BigInteger("1");
        final BigInteger two = new BigInteger("2");
        if (k < 1 || k > n) {
            return one.toString(10);
        }
        k++;

        BigInteger[] window = new BigInteger[k];
        for (int i = 0; i < k; i++) {
            window[i] = one;
        }
        window[k - 1] = new BigInteger("" + (k - 1));

        for (int i = k; i <= n; i++) {
            int ix = i % k;
            BigInteger a = window[(i + k - 1) % k];
            BigInteger b = window[ix];
            BigInteger c = a.multiply(two).subtract(b);
            window[ix] = c;
        }

        return window[n % k].toString(10);
    }
}