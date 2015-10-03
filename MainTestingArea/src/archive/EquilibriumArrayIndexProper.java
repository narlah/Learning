package archive;

import java.util.ArrayList;
import java.util.Arrays;

public class EquilibriumArrayIndexProper {
	public static Integer[] solution(int[] A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		long sum = 0;
		long leftSum = 0;

		for (int e : A)
			leftSum += e;

		for (int i = 0; i < A.length; i++) {
			if (sum == leftSum - A[i])
				result.add(new Integer(i));
			sum += A[i];
			leftSum -= A[i];
		}
		if (result.isEmpty()) {
			return new Integer[] { -1 };
		} else {
			return result.toArray(new Integer[] {});
		}
	}

	public static void main(String args[]) {
		//		System.out.println(solution(new int[] { 1, 2, 1 })); //1
		//		System.out.println(solution(new int[] { -10, 50, 2, 7, 30, 12 })); //3
		//		System.out.println(solution(new int[] { 1, 1, 5, 100, 13, 12, 13, 107 })); //5
		//		System.out.println(solution(new int[] { 100, 0, 7, 63, 30 }));//1
		System.out.println(Arrays.toString(solution(new int[] { -7, 1, 5, 2, -4, 3, 0 })));//6
		//		System.out
		//				.println(solution(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));//10
		//		System.out.println(solution(new int[] { 0, +2147483647, -2147483647 })); //0
	}
}
