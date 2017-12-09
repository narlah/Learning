package archive;

import java.util.Arrays;
import java.util.Random;

public class MaxNumberOfElementsInARow {
    public static void main(String[] args) { // Testing Method
        MaxNumberOfElementsInARow Enclosing = new MaxNumberOfElementsInARow();

        Current current = Enclosing.new Current(null, "����� ������, ������ �����������");
        current.findCurrent();
        current.printCurrent();

        int[] singleElementTest = {1};
        Current currenSingleElement = Enclosing.new Current(singleElementTest, "�������� �������");
        currenSingleElement.findCurrent();
        currenSingleElement.printCurrent();
        System.out.println();
        System.out.println(Arrays.toString(singleElementTest));

        Random rand = new Random();
        final int MASS_TEST_NUM = 10000;
        int[] massTestMatrix = new int[MASS_TEST_NUM];
        for (int j = 0; j < MASS_TEST_NUM; j++) {
            massTestMatrix[j] = rand.nextInt(1000);
        }

        // massTestMatrix[5] = 12;
        // massTestMatrix[6] = 12;
        // massTestMatrix[7] = 12;
        Current massTestCurrent = Enclosing.new Current(massTestMatrix, "����� ���� � 10000 �������� (1-1000)!");
        massTestCurrent.findCurrent();
        massTestCurrent.printCurrent();
        System.out.println();
        System.out.println(Arrays.toString(massTestMatrix));

        int[] currArray = {2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 1, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1};
        Current normalWorkTest = Enclosing.new Current(currArray, "�������� ������ , ������������ 2-��");
        normalWorkTest.findCurrent();
        normalWorkTest.printCurrent();
        System.out.println();
        System.out.println(Arrays.toString(currArray));

    }

    class Current {
        String currentName = null;
        private int[] massive = null;
        private int maxStartPos = 0, maxCount = 0;
        private int currStartPos = 0, currCount = 0;

        Current(int[] inputCurrent, String name) {
            if (inputCurrent == null || inputCurrent.length == 0 || name == null) {
                String defaultName = name == null ? "Current" : name;
                System.out.printf("\n********\n%S invalid, constructor failed!\n\n", defaultName);
            } else {
                this.massive = inputCurrent;
                this.currentName = name;
            }
        }

        public void findCurrent() {
            if (massive == null || massive.length == 0) {
                System.out.println("No valid current in a invalid massive.");
                return;
            }

            for (int i = 0; i < massive.length; i++) {
                if (massive[currStartPos] != massive[i]) { // new element , end
                    // of current
                    if (maxCount < currCount) { // new max values
                        maxCount = currCount;
                        maxStartPos = currStartPos;
                    }
                    currStartPos = i;
                    currCount = 1;
                    continue;
                }
                currCount++;
            }
        }

        public void printCurrent() {
            if (maxCount == 0) {
                System.out.println("Find the current first, before printing!");
            } else {
                System.out.printf("\n********\n%S contains elements \"%d\" and is %d characters long.", currentName,
                        massive[maxStartPos], maxCount);
            }
        }
    }
}
