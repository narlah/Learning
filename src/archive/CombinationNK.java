package archive;

public class CombinationNK {
    public static int numberOfLoops;
    public static int numberOfIterations;
    public static int[] loops;

    public static void main(String[] args) {
        numberOfLoops = 2;
        numberOfIterations = 3;
        loops = new int[numberOfLoops];
        nestedLoops(0, 1);
    }

    public static void nestedLoops(int currentLoop, int counterStart) {
        if (currentLoop == numberOfLoops) {
            printLoops();
            return;
        }
        for (int counter = counterStart; counter <= numberOfIterations; counter++) {
            loops[currentLoop] = counter;
            nestedLoops(currentLoop + 1, counter);
        }
    }

    public static void printLoops() {
        for (int i = 0; i < numberOfLoops; i++) {
            System.out.printf("%d ", loops[i]);
        }
        //System.out.println(Arrays.toString(loops));
        System.out.println();
    }
}