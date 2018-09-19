package learnConcurency;

import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumerUsingSemaphore {
    //private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
    private ArrayList<Integer> queue = new ArrayList<>(1);
    MySemaphore prodSemaphore = new MySemaphore(1);
    MySemaphore consSemaphore = new MySemaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerUsingSemaphore pr = new ProducerConsumerUsingSemaphore();
        pr.doWork();

    }

    private void doWork() throws InterruptedException {
        Thread pr = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread cons = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pr.start();
        Thread.sleep(100);
        cons.start();

        pr.join();
        cons.join();
    }

    private void producer() throws InterruptedException {
        Random random = new Random();
        prodSemaphore.acquire();
        Thread.sleep(500);
        int current = random.nextInt(10);
        System.out.println("prod : " + current);
        queue.add(current);
        consSemaphore.release();
    }

    private void consumer() throws InterruptedException {
        consSemaphore.acquire();
        Thread.sleep(500);
        System.out.printf("cnsm : " + String.valueOf(queue.remove(0)) + "\n");
        prodSemaphore.release();
    }

}
