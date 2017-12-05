package interviewPickings.hackerRank;

public class CheckIfItIsPalindrome {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        String a = sc.next();
        String a = "magzdzgam";
        int len = a.length();
        int half = len/2;
        for (int i = 0; i < half; i++) {
            if (a.charAt(i) != a.charAt(len-i-1)) {System.out.println("No"); return;}
        }
        System.out.println("Yes");

    }
}
