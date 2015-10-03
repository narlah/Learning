package archive;
public class BitOperation {
	public static int findNumberOfBits(int x) {
		int bitCount = 0;

		while (x != 0) {
			// increment count if last binary digit is a 1:
			bitCount += ((x & 1) == 1) ? 0 : 1;
			x = x >> 1; // shift Z by 1 bit to the right
		}

		return bitCount;
	}

	public static void main(String[] args) {
		System.out.println(findNumberOfBits(13));
	}

}
