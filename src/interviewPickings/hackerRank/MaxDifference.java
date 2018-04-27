package interviewPickings.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class MaxDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double input = in.nextDouble();
        double[] userProvided = new double[(int) input];
        for (int i = 0; i < input; i++) {
            userProvided[i] = in.nextDouble();
        }

        //double[] userProvidedAuto = new double[]{-2.2, -3, 4.1, -1.0, -2, 1.7, 5.4, -3, -6, 1.3, 2};
        //System.out.println(getMaxValue(userProvidedAuto.length,userProvidedAuto));
        System.out.println(getMaxValue(userProvided.length,userProvided));
    }

    private static double getMaxValue(int input, double[] userProvided) {
        double maxValue = 0;
        for (int i = input - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                double tempValue = userProvided[i] - userProvided[j];
                if (tempValue > maxValue) {
                    maxValue = tempValue;
                }
            }
        }
        return maxValue;
    }
}
