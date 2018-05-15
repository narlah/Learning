package interviewPickings.codeFights;

import java.math.BigInteger;
import java.util.ArrayList;

public class Kbonaci {
    public static void main(String[] args) {
        Kbonaci kb = new Kbonaci();
        System.out.println(kb.kbonacci(1000, 100000));
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
}