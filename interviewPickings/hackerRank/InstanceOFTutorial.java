package interviewPickings.hackerRank;

import java.util.ArrayList;
import java.util.Scanner;


class Student_1 {
}

class Rockstar {
}

class Hacker {
}


public class InstanceOFTutorial {

    static String count(ArrayList mylist) {
        int a = 0, b = 0, c = 0;
        for (Object element : mylist) {
            if (element instanceof Student_1)
                a++;
            if (element instanceof Rockstar)
                b++;
            if (element instanceof Hacker)
                c++;
        }
        return Integer.toString(a) + " " + Integer.toString(b) + " " + Integer.toString(c);
    }

    public static void main(String[] args) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            if (s.equals("Student_1")) mylist.add(new Student_1());
            if (s.equals("Rockstar")) mylist.add(new Rockstar());
            if (s.equals("Hacker")) mylist.add(new Hacker());
        }
        System.out.println(count(mylist));
    }
}
