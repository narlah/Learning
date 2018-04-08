package archive;

import java.util.ArrayList;
import java.util.Scanner;

public class CoupleTasksWithConsoleMenu {

    //read menu
    private static String readWord(String message) {
        @SuppressWarnings("resource")
        Scanner r = new Scanner(System.in);
        while (true) {
            System.out.printf("\n%s : ", message);
            if (r.hasNextLine()) {
                String s = r.nextLine();
                if (!s.isEmpty())
                    return s;
            } else
                r.next();
        }
    }"after"
    //the 3 methods

    //retrace a number
    private static void printBackwards(String forward) {
        if (!forward.matches("[+-]?\\d*(\\.\\d+)?") || new Double(forward) < 0) {
            System.out.println("Number must be positive Number (>0)! Try again...");
            return;
        }
        StringBuilder build = new StringBuilder(forward.length());
        for (int i = forward.length() - 1; i >= 0; i--) {
            build.append(forward.charAt(i));
        }
        System.out.println(build.toString());
    }

    //average arithmetic
    private static void averageArithmetic() {
        ArrayList<Integer> massiveArray = new ArrayList<>();
        int counter = 1;
        System.out.println("End the sequence with \"finish\"!");
        do {
            String line = readWord("Insert number number " + counter);
            if (line.equals("finish"))
                break;
            if (!line.matches("[+-]?\\d*(\\.\\d+)?") || new Long(line) <= 0)
                continue;
            massiveArray.add(new Integer(line));
            counter++;
        } while (true);
        if (massiveArray.size() == 0) {
            System.out.println("The massive must not be a empty. Try again ...");
            return;
        }
        int result = 0;
        for (Integer i : massiveArray) {
            result += i;
        }
        System.out.print("Average for massive :");
        System.out.println(massiveArray.toString() + " is " + (double) result / (double) massiveArray.size());
    }

    //a*x+b=0
    private static void solveEquation(int a, int b) {
        if (a == 0) {
            System.out.println("\'a\' must not be equal to ZERO. Try again ...");
            return;
        }
        System.out.printf("Equation %d*x+%d=0 , x=%f", a, b, (float) -b / (float) a);
    }

    private static void printMenu() {
        System.out.print("\n\n");
        System.out
                .println("Enter \" 1 \" for backtrack of integer. \nEnter \" 2 \" for average arithmetic. \nEnter \" 3 \" for equation. \n");
    }

    public static void main(String[] args) {
        String input;
        do {
            printMenu();
            input = readWord("Select option");
            if (input.equals("end")) {
                System.out.println("Exiting...");
                break;
            }

            if (new Integer(input) == 1) {
                printBackwards(readWord("Backtrack number"));
            }
            if (new Integer(input) == 2) {
                averageArithmetic();
            }
            if (new Integer(input) == 3) {
                solveEquation(new Integer(readWord("a")), new Integer(readWord("b")));
            }
        } while (true);
    }
}