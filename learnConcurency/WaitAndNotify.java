package learnConcurency;

import java.util.LinkedList;
import java.util.Random;

public class WaitAndNotify {
    Random random = new Random();
    private LinkedList<Integer> list = new LinkedList<>();
    private final int limit = 10;
    Object lock = new Object();


    public void producer() throws InterruptedException {
        System.out.printf("Producer thread running...");
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == limit) {
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                System.out.print("List size is : " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is " + value);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }

    public static void main(String[] args) {
        WaitAndNotify wa = new WaitAndNotify();
        Thread t1 = new Thread(() ->
        {
            try {
                wa.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() ->
        {
            try {
                wa.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}