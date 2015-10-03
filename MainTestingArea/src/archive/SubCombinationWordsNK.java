package archive;

//import java.util.Arrays;

public class SubCombinationWordsNK {
	static String[] s = { "test", "rock", "fun" };
	static int numberOfIterations = s.length;
	static int[] loops = new int[numberOfIterations];

	public static void main(String[] args) {
		nestedLoops(0);
	}

	public static void nestedLoops(int counterStart) {
		for (int counter = counterStart; counter < numberOfIterations; counter++) {
			loops[counter] = 1;
			nestedLoops(counter + 1);
			loops[counter] = 0;
		}
		printLoops();
		if (counterStart == numberOfIterations) {
			return;
		}

	}

	public static void printLoops() {
		System.out.print("{"); //Arrays.toString(loops)+"             
		for (int i = 0; i < numberOfIterations; i++) {
			if (loops[i] != 0) {
				System.out.printf("%s ", s[i]);
			}
		}
		System.out.println("}");
	}

}
