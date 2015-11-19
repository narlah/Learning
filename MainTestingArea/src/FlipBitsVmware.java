import java.util.ArrayList;

public class FlipBitsVmware {
	public static void main(String[] args) {
		FlipBitsVmware a = new FlipBitsVmware();
		System.out.println(a.flip("111"));
	}

	public ArrayList<Integer> flip(String A) {
		int[] a = new int[A.length()];
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (c == '1')
				a[i] = 1;
			else
				a[i] = 0;
		}
		int maxDiff = 0;
		int flipStartIndex = 0;
		int flipEndIndex = 0;
		int onesToFlip = 0;
		int totalNumberOfOnes = 0;

		int currentDiff = 0;
		int currentStart = 0;
		int currentOnesToFlip = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				currentDiff -= 1;
			} else {
				currentDiff += 1;
				currentOnesToFlip++;
				totalNumberOfOnes++;
			}
			if (currentDiff < maxDiff) {
				maxDiff = currentDiff;
				flipStartIndex = currentStart;
				flipEndIndex = i;
				onesToFlip = currentOnesToFlip;
			} else if (currentDiff > 0) {
				currentDiff = 0;
				currentStart = i + 1;
				currentOnesToFlip = 0;
			}
		}
		if (maxDiff==0 && flipStartIndex==0 && flipStartIndex ==0) return new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(flipStartIndex+1);
		result.add(flipEndIndex+1);
		return result;
	}
}
