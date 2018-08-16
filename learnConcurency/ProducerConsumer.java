package learnConcurency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pr = new ProducerConsumer();
        pr.doWork();

    }

    private void doWork() throws InterruptedException {
        Thread pr = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                producer();
            }
        });
        Thread cons = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                consumer();
            }
        });
        pr.start();
        Thread.sleep(100);
        cons.start();

        pr.join();
        cons.join();
    }

    private void producer() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int current = random.nextInt(10);
            System.out.println(current);
            queue.add(current);
        }
    }

    private void consumer() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(String.valueOf(queue.remove()));
        }
    }

}
