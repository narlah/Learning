package interviewPickings.codeFights;

public class WaterLevel {
    public static void main(String[] args) {
        WaterLevel wa = new WaterLevel();
        int[][] arr = new int[][]
                {{21, 26},
                        {32, 26},
                        {40, 9},
                        {63, 20},
                        {85, 19}};
        int energy = 4;
        System.out.println(wa.waterLevel(arr, energy)); //90
    }

    int waterLevel(int[][] gates, int energy) {
        int[][] gateS = new int[gates.length + 1][];
        gateS[0] = new int[]{0, 0};
        System.arraycopy(gates, 0, gateS, 1, gates.length);

        return rec(gateS, energy, 1, 0, "");
    }

    private int rec(int[][] gateS, int currentEnergy, int gate, int minSf, String S) {
        if (gateS.length == gate) {
            System.out.println(S + " = " + minSf);
            return minSf;
        }
        int boost = minSf + (gateS[gate][0] - gateS[gate - 1][0]);
        int onTime = boost % gateS[gate][1];
        int wait = boost + (gateS[gate][1] - onTime);

        //wait all
        if (currentEnergy == 1)
            return rec(gateS, currentEnergy, gate + 1, wait, S + "W+ ");
        //boost all
        if ((gateS.length - gate) <= currentEnergy - 1)
            return rec(gateS, currentEnergy, gate + 1, boost, S + "B+ ");

        if (onTime == 0)
            return rec(gateS, currentEnergy, gate + 1, boost, S + "O! ");

        return Math.min(
                rec(gateS, currentEnergy, gate + 1, wait, S + "W- "),
                rec(gateS, currentEnergy - 1, gate + 1, boost, S + "B- "));

    }

}
