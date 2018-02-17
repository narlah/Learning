package interviewPickings;

public class GenerateSubStrings {
    public static void main(String[] args) {
        GenerateSubStrings gen = new GenerateSubStrings();
        char[] chars = {'a', 'b', 'c'};
//        gen.printSubstrings(chars, 0, 1);
        gen.printSubstringsIter(chars);
        System.out.println();
        gen.printSubstrings(chars, 0, 1);
    }

    private void printSubstrings(char[] chars, int start, int end) {
        int total = chars.length;
        if (start == total && end == total) {
            return;
        } else {
            if (end == total + 1) {
                printSubstrings(chars, start + 1, start + 1);
            } else {
                for (int i = start; i < end; i++) {
                    System.out.print(chars[i] + " ");
                }
                System.out.println();
                printSubstrings(chars, start, end + 1);
            }
        }

    }

    private void printSubstringsIter(char[] chars) {
        int length = chars.length;
        for (int c = 0; c < length; c++) {
            for (int i = 1; i <= length - c; i++) {
                for (int z = c; z < c + i; z++) {
                    System.out.print(chars[z] + " ");
                }
                System.out.println();
            }
        }
    }
}
