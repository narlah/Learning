package learnConcurency;

import java.util.Random;

public class ExecutorServiceNK {

    private final int maxT;
    private int currrentT;

    public ExecutorServiceNK() {
        maxT = 3;
        currrentT = 3;
    }

    public ExecutorServiceNK(int maxT) {
        this.maxT = maxT;
        this.currrentT = maxT;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorServiceNK exNK = new ExecutorServiceNK();
        for (int i = 0; i < 10; i++) {
            final int carryOn = i;
            exNK.execute(() -> {
                System.out.println("thread n: " + carryOn);
                try {
                    Random r = new Random();
                    Thread.sleep(r.nextInt(10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Finished!");
    }


    public synchronized void execute(Runnable r) throws InterruptedException {
        if (currrentT == 0) wait();
        currrentT--;
        Runnable r1 = () -> {
            r.run();
            notifyTheExecutor();
        };
        Thread t = new Thread(r1);
        t.start();

    }

    private synchronized void notifyTheExecutor() {
        currrentT++;
        notify();
    }
}
