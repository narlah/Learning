package interviewPickings.codeFights;

import java.util.ArrayList;

public class WaterLevel {
    public static void main(String[] args) {
        WaterLevel wa = new WaterLevel();
        int[][] arr = new int[501][2];
        for (int i = 0; i <= 500; i++) {
            arr[i][0] = i * 10 + 1;
            arr[i][1] = i * 13 + 1;
        }
        //int[][] arr = new int[][]{};
        int energy = 4;
        long in = System.nanoTime();
        System.out.println(wa.waterLevel(arr, energy)); //90
        System.out.println("time elapsed : " + (System.nanoTime() - in) / 1000000000);
    }

    int waterLevel(int[][] gates, int energy) {
        int[][] gateS = new int[gates.length + 1][];
        gateS[0] = new int[]{0, 0};
        System.arraycopy(gates, 0, gateS, 1, gates.length);
        ArrayList<Integer> arr = new ArrayList<>(1);
        arr.add(Integer.MAX_VALUE);
        return rec(gateS, energy, 1, 0, arr);
    }

    private int rec(int[][] gateS, int currentEnergy, int cGate, int minSf, ArrayList<Integer> arr) {
        if (minSf > arr.get(0))
            return Integer.MAX_VALUE;
        if (gateS.length == cGate) {
            arr.set(0, minSf);
            return minSf;
        }
        int boost = minSf + (gateS[cGate][0] - gateS[cGate - 1][0]);
        int onTime = boost % gateS[cGate][1];
        int wait = boost + (gateS[cGate][1] - onTime);

        //wait all
        if (currentEnergy == 1)
            return rec(gateS, currentEnergy, cGate + 1, wait, arr);
        //boost all
        if ((gateS.length - cGate) <= currentEnergy - 1)
            return rec(gateS, currentEnergy, cGate + 1, boost, arr);
        //on time skip ahead without losing energy
        if (onTime == 0)
            return rec(gateS, currentEnergy, cGate + 1, boost, arr);

        return Math.min(
                rec(gateS, currentEnergy, cGate + 1, wait, arr),
                rec(gateS, currentEnergy - 1, cGate + 1, boost, arr));
    }

}
