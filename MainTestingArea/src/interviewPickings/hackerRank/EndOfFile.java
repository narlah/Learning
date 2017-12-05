package interviewPickings.hackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class EndOfFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> array = new ArrayList<>();
        while (sc.hasNext()) {
            array.add(sc.nextLine());
        }
        for (int i = 0; i < array.size(); i++) {
            System.out.println((i+1) + " " + array.get(i));
        }
    }
}