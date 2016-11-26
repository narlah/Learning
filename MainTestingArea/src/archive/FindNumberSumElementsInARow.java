package archive;

import java.util.Arrays;
import java.util.Random;

public class FindNumberSumElementsInARow {
    class Current {
        private int[] massive = null;
        private int startIndex = 0, endIndex = 0;
        private int currentSum = 0;
        ; // maybe the first element is our hero ?

        private int findThisSum = 0;
        String currentName = null;

        Current(int[] inputCurrent, String name, int fTS) {
            if (inputCurrent == null || inputCurrent.length == 0 || name == null) {
                String defaultName = name == null ? "Current" : name;
                System.out.printf("\n********\n%S invalid, constructor failed!\n\n", defaultName);
            } else {
                this.massive = inputCurrent;
                this.currentSum = massive[0];
                this.currentName = name;
                this.findThisSum = fTS;
                System.out.println("\n*****************************");
                System.out.println("Process started for : " + name);
            }
        }

        public void findCurrent() {
            if (massive == null || massive.length == 0) {
                System.out.println("No valid current in a invalid massive.");
                return;
            }
            int lenght = massive.length;
            do {
                if (currentSum == findThisSum) { // found
                    return;
                } else if (currentSum < findThisSum) {
                    if (endIndex == lenght - 1 && startIndex < endIndex) {// end is finished , sum still smaller
                        currentSum -= massive[startIndex];// must reduce the sum in case we have negatives somewhere
                        startIndex++;
                    } else if (endIndex < lenght - 1) {
                        endIndex++;// more can be added
                        currentSum += massive[endIndex];
                    } else
                        return; // end reached, sum not found
                } else if (currentSum < 0 && startIndex < endIndex && endIndex <= lenght - 1) {
                    currentSum -= massive[startIndex]; // added negatives ,
                    startIndex++; // must reduce in case <0
                } else if (currentSum > findThisSum && startIndex == lenght - 1) {
                    return;// last number >searched sum
                } else if (currentSum > findThisSum && startIndex < endIndex) {
                    do {// reduce sum, sI++
                        currentSum -= massive[startIndex];
                        startIndex++;
                        if (startIndex == endIndex && massive[startIndex] > findThisSum && startIndex < lenght - 1) {
                            startIndex++;
                            endIndex++;
                            currentSum = massive[startIndex];
                        }
                    } while (currentSum > findThisSum && startIndex < endIndex);
                }
            } while (currentSum != findThisSum);
        }

        public void printCurrent() {
            if (massive == null || massive.length == 0) {
                System.out.println("Fill the massive first, before printing!");
            } else if ((startIndex == endIndex && endIndex == massive.length && findThisSum != massive[endIndex]) || currentSum != findThisSum) {
                System.out.println("Could not find one!");
            } else {
                System.out.printf("The sum %d is found between position %d and %d : ", findThisSum, startIndex, endIndex);
                for (int i = startIndex; i <= endIndex; i++) {
                    System.out.print(massive[i] + " ");
                }
                System.out.println("\n****************");
            }
        }

        private FindNumberSumElementsInARow getOuterType() {
            return FindNumberSumElementsInARow.this;
        }
    }

    public static void printStartInfo(int[] mas, String Find_element) {
        System.out.println("We are searching for : " + Find_element);
        System.out.println(Arrays.toString(mas));
    }

    public static void main(String[] args) { // Testing Method
        FindNumberSumElementsInARow Enclosing = new FindNumberSumElementsInARow();
        // *************** fail constructor
        Current current = Enclosing.new Current(null, "����� ������, ������ �����������", -1);
        current.findCurrent();
        current.printCurrent();
        // *************** single element
        int findSingleN = 110;
        int[] singleElementTest = {-90, -10, 1, 1, 8, 100};
        Current currenSingleElement = Enclosing.new Current(singleElementTest, "�������� �������", findSingleN);
        printStartInfo(singleElementTest, findSingleN + "");
        currenSingleElement.findCurrent();
        currenSingleElement.printCurrent();
        // *************** mass
        Random rand = new Random();
        final int MASS_TEST_NUM = 10000;
        int[] massTestMatrix = new int[MASS_TEST_NUM];
        for (int j = 0; j < MASS_TEST_NUM; j++) {
            massTestMatrix[j] = rand.nextInt(1000);
        }

        // massTestMatrix[5] = 12;
        // massTestMatrix[6] = 12;
        // massTestMatrix[7] = 12;
        int findMassN = 545454;
        Current massTestCurrent = Enclosing.new Current(massTestMatrix, "����� ���� � 10000 �������� (1-1000)!", findMassN);
        printStartInfo(massTestMatrix, findMassN + "");
        massTestCurrent.findCurrent();
        massTestCurrent.printCurrent();
        // *************** normal
        int findNormalN = 12;// rand.nextInt(50);
        int[] currArray = {2, 1, 1, 2, -4, -6, 2, 2, 2, -1, 3, 3, 8, 2, 2, 1, 7, -1, 7, 7, 1, 1, 1, 1, 1, 1};
        Current normalWorkTest = Enclosing.new Current(currArray, "�������� ������ , ������������ 2-��", findNormalN);
        printStartInfo(currArray, findNormalN + "");
        normalWorkTest.findCurrent();
        normalWorkTest.printCurrent();

    }
}
