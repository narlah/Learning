package interviewPickings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SpareChange {
    public static void main(String[] args) {
        SpareChange sp = new SpareChange();
        int[] coins = new int[]{186, 419, 83, 408};
        System.out.println(sp.coinChange(coins, 6249)); //20 is expected
    }

//    public int coinChange(int[] coins, int amount) {
//        if (amount < 1) return 0;
//        return helper(coins, amount, new int[amount]);
//    }
//
//    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
//        if (rem < 0) return -1; // not valid
//        if (rem == 0) return 0; // completed
//        if (count[rem - 1] != 0) return count[rem - 1]; // already computed, so reuse
//        int min = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int res = helper(coins, rem - coin, count);
//            if (res >= 0 && res < min)
//                min = 1 + res;
//        }
//        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//        return count[rem - 1];
//    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        ArrayList<Integer> arr = new ArrayList<>(3);
        arr.add(amount);//0 amount
        arr.add(0); //1 upTo
        arr.add(-1); //2 min_count
        rec(coins, arr, 0, 0);
        return arr.get(2);
    }

    private void rec(int[] coins, ArrayList<Integer> params, int currentSum, int currentCount) {
        if (params.get(2) != -1)
            return;
        if (currentSum == params.get(0)) {
            params.set(2, currentCount);
            return;
        }
        if (currentSum < params.get(0)) {
            for (int i = coins.length - 1 - params.get(1); i >= 0; i--) {
                rec(coins, params, currentSum + coins[i], currentCount + 1);
            }
        } else {
            params.set(1, params.get(1) + 1);
        }
    }

}
