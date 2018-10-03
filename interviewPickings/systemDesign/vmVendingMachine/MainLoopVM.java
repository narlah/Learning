package interviewPickings.systemDesign.vmVendingMachine;

import java.util.Scanner;

public class MainLoopVM {
    public static void main(String[] args) {
        MainLoopVM main = new MainLoopVM();
        main.init();
        main.runMainLoop();
    }

    private void init() {
        //load stuff from disk
    }


    private void runMainLoop() {
        VendingMachine vm = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(createMainMenu());
            choice = readIntConsole(scanner);
            switch (choice) {
                case 0:
                    System.out.println("Exiting ...");
                    return;
                case 1:
                    System.out.println(vm.listMenu());
                    break;
                default:
                    System.out.println("Do nothing, try something else instead!");
            }
        }
    }

    private String createMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("0 exits \n1 lists\nRest Do nothing.\nEnter your choice :");
        return sb.toString();
    }

    private int readIntConsole(Scanner scanReader) {
        int counter = 0;
        while (true) {
            if (scanReader.hasNextInt()) {
                int n = scanReader.nextInt();
                if (n != 0 & n <= 9) {
                    return n;
                } else {
                    System.out.println("Nope, out of bounds, try again!");
                }
            } else {
                System.out.println("Nope,not an int, try again!");
                scanReader.next();
            }
            counter++;
            if (counter > 10) return 0;
        }

    }


}
