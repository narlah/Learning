package interviewPickings.hackerRank;

import java.util.Scanner;

class GenerateSeries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            generate(a, b, n);
        }
        in.close();
    }

    private static void generate(int a, int b, int n) {
        StringBuilder result = new StringBuilder();
        double current = a + Math.pow(2, 0) * b;
        for (int i = 1; i < n; i++) {
            result.append((int) current + " ");
            current = current + (b * Math.pow(2, i));
        }
        result.append((int) current + " ");
        System.out.println(result.toString());
    }
}

