package others;

public class PrintAscii {
    public static void main(String[] args) {
        for (int i = 0; i < 256; i += 3) {
            System.out.println((char) i + " == " + i + " | " + (char) (i + 1) + " == " + (i + 1) + " | " + (char) (i + 2) + " == " + (i + 2));
        }
    }
}
