package tools;

import java.util.Scanner;


public class Console {
    public static int readConsoleForN() {
        Scanner scanReader = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter N (1-30): ");
            if (scanReader.hasNextInt()) {
                int n = scanReader.nextInt();
                if (n != 0 & n <= 30) {
                    return n;
                } else {
                    System.out.println("Nope, out of bounds, try again!");
                }
            } else {
                System.out.println("Nope,not an int, try again!");
                scanReader.next();
            }
        }
    }
}
