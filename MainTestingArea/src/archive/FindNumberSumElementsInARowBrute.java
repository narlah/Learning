package archive;

import java.util.Random;
import java.util.Arrays;

public class FindNumberSumElementsInARowBrute {
	class Current {
		private int[] massive = null;
		private int startIndex = 0, endIndex = 0;
		private int currentSum = 0;; // maybe the first element is our hero ?

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
			for (int n = 0; n < lenght - 1; n++) {
				startIndex = 0;
				endIndex = n;
				currentSum = 0;
				for (int i = 0; i <=n; i++)
					// build up first n elements
					currentSum += massive[i];

				while (currentSum != findThisSum && endIndex < lenght-1) {
					endIndex++;
					currentSum += massive[endIndex];
					if (currentSum == findThisSum) // found
						return;
					currentSum -= massive[startIndex];
					startIndex++;


				}
			}
		}

		public void printCurrent() {
			if (massive == null || massive.length == 0) {
				System.out.println("Fill the massive first, before printing!");
			} else if ((startIndex == endIndex && endIndex == massive.length && findThisSum != massive[endIndex])
					|| currentSum != findThisSum) {
				System.out.println("Could not find one!");
			} else {
				System.out.printf("The sum %d is found between position %d and %d : ", findThisSum,
						startIndex, endIndex);
				for (int i = startIndex; i <= endIndex; i++) {
					System.out.print(massive[i] + " ");
				}
				System.out.println("\n****************");
			}
		}
	}

	public static void printStartInfo(int[] mas, String Find_element) {
		System.out.println("We are searching for : " + Find_element);
		System.out.println(Arrays.toString(mas));
	}

	public static void main(String[] args) { // Testing Method
		FindNumberSumElementsInARowBrute Enclosing = new FindNumberSumElementsInARowBrute();
		// *************** fail constructor
		Current current = Enclosing.new Current(null, "Поток Двойки, Празен конструктор", -1);
		current.findCurrent();
		current.printCurrent();
		// *************** single element
		int findSingleN = 100;
		int[] singleElementTest = { -90, -10, 1, 1, 8, 100, 10 };
		Current currenSingleElement = Enclosing.new Current(singleElementTest, "Единичен елемент",
				findSingleN);
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
		Current massTestCurrent = Enclosing.new Current(massTestMatrix,
				"Масов Тест с 10000 елемента (1-1000)!", findMassN);
		printStartInfo(massTestMatrix, findMassN + "");
		massTestCurrent.findCurrent();
		massTestCurrent.printCurrent();
		// *************** normal
		int findNormalN = -10;// rand.nextInt(50);
		int[] currArray = { 2, 1, 1, 2, -4, -6, 2, 2, 2, -1, 3, 3, 8, 2, 2, 1, 7, -1, 7, 7, 1, 1, 1, 1, 1, 1 };
		Current normalWorkTest = Enclosing.new Current(currArray, "Нормална работа , предполагаме 2-ки",
				findNormalN);
		printStartInfo(currArray, findNormalN + "");
		normalWorkTest.findCurrent();
		normalWorkTest.printCurrent();
	}
}
