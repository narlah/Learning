package learnConcurency;

import java.util.concurrent.*;

public class BusyLoop {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future1 = executor.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "first";
        });
        Future<String> future2 = executor.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "second";
        });
        Thread.sleep(200);
        if (future2.isDone())
            System.out.println("already r2 " + future2.get());
        String result1 = future1.get();
        System.out.println("r1 " + result1);
        String result2 = future2.get();

        System.out.println("r2 " + result2);
        System.out.println(result1 + " " + result2);
    }
}
