package interviewPickings.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class I100doors100monkeys {


    public static void main(String[] args) {

        //link : https://rosettacode.org/wiki/100_doors#Java
        boolean[] doors = new boolean[101];
        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                if (j % i == 0) doors[j] = !doors[j];
            }
        }
        ArrayList open = new ArrayList();
        for (int i = 1; i <= 100; i++) {
            if (doors[i]) open.add(i);
            System.out.printf("Door %d: %s%n", i, doors[i] ? "open" : "closed");
        }
        System.out.println(Arrays.toString(open.toArray()));
//        char[] charA = new char[100];
//        for (int i = 0; i < 100; i++) {
//            charA[i] = '1';
//        }
//        int counter;
//        for (int j = 1; j <= 98; j++) {
//            counter = j-1;
//            while (counter < 99) {
//                char a = charA[counter];
//                System.out.println(counter);
//                charA[counter] = a == '0' ? '1' : '0';
//                counter += j;
//
//            }
//            System.out.println();
//        }
//        System.out.println(Arrays.toString(charA));
//        for (int i = 0; i < 100; i++) {
//            if (charA[i] == '0')
//                System.out.print(i+1 + " ,  ");
//
//        }
    }
}
