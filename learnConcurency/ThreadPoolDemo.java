package learnConcurency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    class Processor implements Runnable {
        private int id;

        public Processor(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Starting : " + id);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Completed :" + id);
        }
    }


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadPoolDemo th = new ThreadPoolDemo();
        th.process(executor);
        executor.shutdown();
    }

    private void process(Executor executor) {
        for (int i = 0; i < 10; i++) {
            executor.execute(new Processor(i));
        }
    }
}
