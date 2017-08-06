package archive;

import java.util.Arrays;

public class SubCombinationWordsNK {
    static String[] s = {"test", "rock", "fun"};
    private static int numberOfIterations = s.length;
    private static int[] loops = new int[numberOfIterations];

    public static void main(String[] args) {
        nestedLoops(0);

    }

    private static void nestedLoops(int counterStart) {
        for (int counter = counterStart; counter < numberOfIterations; counter++) {
            loops[counter] = 1;
            nestedLoops(counter + 1);
            loops[counter] = 0;
        }
        printLoops();
        System.out.println(Arrays.toString(loops));
    }

    private static void printLoops() {
        System.out.print("{");
        for (int i = 0; i < numberOfIterations; i++) {
            if (loops[i] != 0) {
                System.out.printf("%s ", s[i]);
            }
        }
        System.out.println("}");
    }

}
