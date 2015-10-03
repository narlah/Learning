package archive;

public class FibonaciIterRec {

	public static int fibonacci(int n) {
		if (n < 2) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static int fibonacciIter(int n) {
		if (n < 2) {
			return n;
		} else {
			int sum = 0;
			int nMinus1 = 1;
			int nMinus2 = 1;
			for (int i = 2; i < n; i++) {
				sum = nMinus1 + nMinus2;
				nMinus2 = nMinus1;
				nMinus1 = sum;
				
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		// ***************************f6**********************************
		long t1 = System.nanoTime();
		System.out.println(fibonacci(35));
		long t2 = System.nanoTime();
		System.out.println("Time takes for iterative : " + (t2-t1));
		long i1 = System.nanoTime();
		System.out.println(fibonacciIter(35));
		long i2 = System.nanoTime();
		System.out.println("Time takes for iterative : " + (i2-i1));
		// ***************************************************************
	}
}
// ***************************************************************
// System.out.println(Runtime.getRuntime().availableProcessors());
// ***************************************************************
