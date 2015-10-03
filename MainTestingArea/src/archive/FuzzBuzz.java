package archive;

public class FuzzBuzz {
	// %3 %5

	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
				continue;
			}
			String str = i % 3 == 0 ? "Fuzz" : "";
			str += i % 5 == 0 ? "Buzz" : "";

			System.out.println(str.length() != 0 ? str : i);
		}
	}
}
