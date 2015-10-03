package archive;
public class ReverseANumber {

	public static void main(String[] args) {
		System.out.println(reverse(1234567));
	}

	private static int reverse(int in) {
		int result = 0;
		while (in != 0) {
			result = result * 10 + in % 10;
			in = in / 10;

		}
		return result;
	}
}
