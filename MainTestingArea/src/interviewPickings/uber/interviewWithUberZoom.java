package interviewPickings.uber;

import java.util.ArrayList;

public class interviewWithUberZoom {
    public static int LIMIT = 10;

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        interviewWithUberZoom sol = new interviewWithUberZoom();
        //sol.balancer();
    }

//    public void balancer() {
//
//        long lastSecondTimer = System.time();
//        volatile int currentTransaction = 0;
//        ArrayList lastTransactions = new ArrayList();
//        for (int i = 0; i < 100; i++) {
//
//            receive("Transaction with id : " + i, lastTransactions);
//            //sleep ?
//        }
//    }
//
//    public static void receive(String s, ArrayList lastTransactions) {
//        long currentMilysecond = System.time();
//        if (lastTransactions.size() > 10 && lastTransactions.get(lastTransactions.size() - 10)).time<System.time
//        () - 1000)
//        throw RunTimeException("Limit reached, try again later.");
//        //launch request
//        currentTransaction++;
//    }
//
//    class Timer implements Runable {
//        public void run() {
//            while (true) {
//                Thread.sleep(1000);
//                trimArrayList();
//                milysecondTimer = System.time();
//                currentTransaction = 0;
//            }
//        }
//    }
}
