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
        System.out.println(vm.listMenu());
        String mainMenuString = createMainMenu();
        System.out.print(mainMenuString);
        while (true) {
            choice = readIntConsole(scanner);
            switch (choice) {
                case 0:
                    System.out.print(mainMenuString);
                    break;
                case 1:
                    System.out.println(vm.listMenu());
                    break;
                case 2:
                    int article = readIntConsole(scanner);
                    int moneyIn = readIntConsole(scanner);
                    VendingItem vitem = vm.getItem(article);
                    float price = vitem.getPrice();
                    if (moneyIn < price) {
                        System.out.println("Not enough minerals! Try again");
                        break;
                    }
                    System.out.println(String.format("You bought item %s for %.2f and you have %.2f change. Have a nice day!",
                            vitem.getName(), vitem.getPrice(), moneyIn - vitem.getPrice()));
                    break;
                case 9:
                    System.out.println("Exiting ...");
                    return;
                default:
                    System.out.println("Do nothing, try something else instead!");
            }
        }
    }

    private String createMainMenu() {
        return "0 print help \n1 lists \n2 buys id with X money ex: <2 3 5> - [buys article id 3 with 5$ note] \n" +
                "9 exits\nRest Do nothing.\nEnter your choice : ";
    }

    private int readIntConsole(Scanner scanReader) {
        int counter = 0;
        while (true) {
            if (scanReader.hasNextInt()) {
                int n = scanReader.nextInt();
                if (n >= 0 & n <= 100) {
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
