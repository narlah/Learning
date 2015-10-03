package archive;
import java.util.Arrays;

public class FindMedianWithQuickSearch {
	public static void main(String[] args) {
		FindMedianWithQuickSearch f = new FindMedianWithQuickSearch();
		int[] arr = { 12, 11, 15, 7, 6, 5, 10, 20, 0,100 };
		System.out.println(f.findMedian(arr)); 

	}

	private int findMedian(int[] arr) {
		int medianPosition = arr.length / 2;
		while (true) {
			int bellow = -1, above = -1;
			System.out.println(Arrays.toString(arr));
			for (int i = 0; i < medianPosition - 1; i++) {
				if (arr[i] > arr[medianPosition]) {
					bellow = i;
					break;
				}
			}
			for (int j = medianPosition + 1; j <= arr.length - 1; j++) {
				if (arr[j] < arr[medianPosition]) {
					above = j;
					break;
				}
			}
			if (bellow == above) {
				break;
			}

			if (bellow != -1 && above != -1) {
				int temp = arr[bellow];
				arr[bellow] = arr[above];
				arr[above] = temp;
			}
			if (bellow != -1 && above == -1 || above != -1 && bellow == -1) {
				int replaceThis = bellow > above ? bellow : above;
				int temp = arr[medianPosition];
				arr[medianPosition] = arr[replaceThis];
				arr[replaceThis] = temp;
			}
		}
		return arr[medianPosition];
	}
}
