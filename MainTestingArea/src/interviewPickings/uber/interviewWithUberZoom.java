package interviewPickings.uber;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class interviewWithUberZoom {
    public static int LIMIT = 10;
    Vector<Transaction> lastTransactions = new Vector<>();

    public static void main(String args[]) throws Exception {
        interviewWithUberZoom sol = new interviewWithUberZoom();
        sol.balancer();
    }

    private void balancer() throws InterruptedException {
        Thread thread = new Thread(new Timer());
        thread.start();

        for (int i = 0; i < 100; i++) {
            receive("Transaction with id : " + i, lastTransactions);
            if (i < 50)
                TimeUnit.MILLISECONDS.sleep(101);
        }
    }

    private void receive(String s, Vector lastTransactions) {
        long currentMillisecond = System.currentTimeMillis();

        if (lastTransactions.size() > LIMIT) {
            Transaction t = ((Transaction) lastTransactions.get(lastTransactions.size() - LIMIT));
            System.out.println(lastTransactions.size() + " " + t.time + " " + t.data + " " + currentMillisecond + " = " + (currentMillisecond - t.time));
        }
        if (lastTransactions.size() > LIMIT && (currentMillisecond - ((Transaction) lastTransactions.get(lastTransactions.size() - LIMIT)).time) < 1000) {
            System.out.println("WARNING");
            throw new RuntimeException("Limit reached, try again later.");
        }
        System.out.println(s); //sending it
        lastTransactions.add(new Transaction(s, System.currentTimeMillis()));
    }

    class Timer implements Runnable {
        public void run() {
            int currentTick = 0;
            while (true) {
                if (currentTick > 5) break;
                try {
                    Thread.sleep(1000);
                    System.out.println("ticker : " + currentTick);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentTick++;
                //trimArrayList should be implemented in case we run long list of course, but we can keep it as a log - lets say
                //create empty array list while sending an old one to a new Thread that will save the content to a db or log file.
            }
        }
    }

    class Transaction {
        Transaction(String data, long time) {
            this.data = data;
            this.time = time;
        }

        String data;

        public long getTime() {
            return time;
        }

        long time;
    }


}
