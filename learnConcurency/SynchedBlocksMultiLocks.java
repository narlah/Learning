package learnConcurency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchedBlocksMultiLocks {
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private Random random = new Random();
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    private void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }


    public static void main(String[] args) {
        SynchedBlocksMultiLocks sy = new SynchedBlocksMultiLocks();
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> sy.process());
        t1.start();
        Thread t2 = new Thread(() -> sy.process());
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken " + (end - start));
        System.out.println("List one size : " + sy.list1.size());
        System.out.println("List one size : " + sy.list2.size());
    }
}
