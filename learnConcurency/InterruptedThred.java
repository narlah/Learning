package learnConcurency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InterruptedThred {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting ...");

        //justAThread();
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> fu = executor.submit(() -> {
            Random random = new Random();
            for (int i = 0; i < 1E8; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("We have been interrupted");
                    break;
                }
                Math.sin(random.nextDouble());
            }
        });
        executor.shutdown();
        Thread.sleep(500);
        fu.cancel(true); //this sets the interrupt flag
        //executor.shutdownNow(); //sets interrupted flag to all in the executor
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Finished.");
    }

    private static void justAThread() throws InterruptedException {
        Thread t = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 1E8; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("We have been interrupted");
                    break;
                }
//                try {
//                    Thread.sleep(1);
//
//     } catch (InterruptedException e) {
//                    System.out.println("We have been interrupted");
//                    break;
//                }
                Math.sin(random.nextDouble());
            }
        });
        t.start();
        Thread.sleep(500);

        t.interrupt();

        t.join();
    }
}