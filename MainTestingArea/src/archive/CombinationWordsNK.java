package archive;

public class CombinationWordsNK {
    static String[] s = {"test", "rock", "fun", "gun"};
    static int numberOfLoops = 2;
    static int numberOfIterations = 4;
    static int[] loops = new int[numberOfLoops];

    public static void main(String[] args) {
        nestedLoops(0, 0);
    }

    public static void nestedLoops(int currentLoop, int counterStart) {
        if (currentLoop == numberOfLoops) {
            printLoops();
            return;
        }
        for (int counter = counterStart; counter < numberOfIterations; counter++) {
            loops[currentLoop] = counter;
            nestedLoops(currentLoop + 1, counter + 1);
        }
    }

    public static void printLoops() {
        for (int i = 0; i < numberOfLoops; i++) {
            System.out.printf("%s ", s[loops[i]]);
        }
        System.out.println();
    }

}
