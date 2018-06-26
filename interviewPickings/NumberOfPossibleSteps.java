package interviewPickings;

public class NumberOfPossibleSteps {
    public static void main(String[] args) {
        NumberOfPossibleSteps nu = new NumberOfPossibleSteps();
        int[] steps = new int[]{2, -1};
        System.out.println(nu.getNumberOfPossibleStepsInN(5, steps));
    }

    private int getNumberOfPossibleStepsInN(int n, int[] steps) {
        if (steps.length == 0) return 0;  // what happen if we have negative steps , 2 forward , one backwards ?

        return recSteps(0, 0, steps, n);

    }

    private int recSteps(int currentStep, int currentStepCounter, int[] steps, int maxSteps) {
        if (currentStep == maxSteps)
            return 1;
        if (currentStepCounter > 2 * maxSteps || currentStep > maxSteps)
            return 0;
        int sum = 0;
        for (int z : steps) {
            if (currentStep + z < 0) continue;
            sum += recSteps(currentStep + z, currentStepCounter + 1, steps, maxSteps);
        }
        return sum;
    }

//    private int getNumberOfPossibleStepsInN(int n) {
//        return recSteps(0, n);
//
//    }
//
//    private int recSteps(int i, int n) {
//        if (i == n)
//            return 1;
//        if (i > n)
//            return 0;
//        return recSteps(i + 1, n) + recSteps(i + 2, n);
//    }
}
