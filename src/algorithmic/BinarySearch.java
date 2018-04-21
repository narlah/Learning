package algorithmic;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String arg[]) {
        int massive[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 56, 78, 45, 89};
        int startIndex;
        int endIndex;
        int currentMiddle;
        int findEntered;
        do {
            findEntered = readN();
            if (findEntered == -1) {
                System.out.println("Exit command send , exiting!");
                break;
            }
            startIndex = 0;
            endIndex = massive.length - 1;
            currentMiddle = endIndex / 2;
            System.out.println(currentMiddle);
            while (massive[currentMiddle] != findEntered & startIndex != endIndex) {
                if (massive[currentMiddle] > findEntered) {
                    endIndex = currentMiddle - 1;
                } else {
                    startIndex = currentMiddle + 1;
                }
                currentMiddle = startIndex + (endIndex - startIndex) / 2;
            }
            if (massive[currentMiddle] == findEntered) {
                System.out.printf("Found the element \"%d\" at position %d", findEntered, currentMiddle);
            } else {
                System.out.printf("NOPE for \"%d\"", findEntered);
            }
        } while (true);
        // System.out.println(Arrays.toString(massive));
    }

    private static int readN() {
        @SuppressWarnings("resource")
        Scanner r = new Scanner(System.in);
        while (true) {
            System.out.print("\nPlease enter a number between 1-100 : ");
            if (r.hasNextInt()) {
                int n = r.nextInt();
                if (n != 0 && n >= 0 && n <= 100)
                    return n;
            } else if (r.hasNext("Exit")) {
                return -1;
            } else {
                r.next();
            }
        }
    }
}
