package interviewPickings;

public class WordSquareInterviewQuestion {

    public static void main(String[] args) {
        //tests
        String twoByTwoString = "abbz";
        String treeByThreeString = "abcbkdcdc";
        String fourByFourString = "abcdb_klck_zdlz_";
        String fiveByFiveString = "abcdeb_klmck_ztdlz_remtr_";
        System.out.println("2х2 correct  " + isSquareWord(twoByTwoString));
        System.out.println("3x3 correct  " + isSquareWord(treeByThreeString));
        System.out.println("4x4 correct  " + isSquareWord(fourByFourString));
        System.out.println("5x5 correct  " + isSquareWord(fiveByFiveString));
        System.out.println("NOT correct lenght - not power of two  " + isSquareWord("abcde"));
        System.out.println("3x3 NOT correct  " + isSquareWord("abczjkccc"));
        System.out.println("5x5 NOT correct  " + isSquareWord("abcdeb_11111_ztdlz_22222_"));
    }

    private static boolean isSquareWord(String prosedString) {
        int length = prosedString.length();
        int n = (int) Math.sqrt(prosedString.length());
        if (length == 0 || !isPerfectSquare(length))
            return false;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < row; col++) {
                if (prosedString.charAt(row * n + col) != prosedString.charAt(col * n + row)) {
                    return false;
                }
            }
        }

        return true;
    }

    public final static boolean isPerfectSquare(long n) {
        if (n < 0)
            return false;
        long tst = (long) (Math.sqrt(n) + 0.5);
        return tst * tst == n;
    }

}
