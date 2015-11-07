public class CheckStringForPalindrome {
	public static void main(String[] args) {
		CheckStringForPalindrome main = new CheckStringForPalindrome();
		System.out.println(main.checkStringForPalindrome("1A man, a plan, a canal: Panama"));
	}

	private int checkStringForPalindrome(String string) {
		String procesed = string.replaceAll("[^a-zA-Z0-9s+]", "").toLowerCase();		
		System.out.println(procesed);
		if (procesed.length() == 0)
			return 1;
		int n = procesed.length();
		for (int i = 0; i < n; i++) {
			if (procesed.charAt(i) != (procesed.charAt(n - i - 1)))
				return 0;
		}
		return 1;
	}
}
