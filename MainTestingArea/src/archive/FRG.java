package archive;

import java.util.Scanner;

public class FRG {

    private static int readN() {
        @SuppressWarnings("resource")
        Scanner r = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter the number N : ");
            if (r.hasNextInt()) {
                int n = r.nextInt();
                if (n != 0)
                    return n;
            } else
                r.next();
        }
    }

    public static void main(String[] args) {
        System.out.println("N:" + readN());
    }
}