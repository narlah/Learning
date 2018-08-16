package learnConcurency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//idea - counters at bank tellers (3 counters, 10 people waiting, one semaphore)
public class SemaphoreUsingMutex {
    MySemaphore semaphore = new MySemaphore(3);
    Random random = new Random();

    public static void main(String[] args) {
        SemaphoreUsingMutex SS = new SemaphoreUsingMutex();
        SS.startExecutor();
    }

    private void startExecutor() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int passIT = i;
            executor.execute(() -> {
                int param = passIT;
                try {
                    goToTeller(passIT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void goToTeller(int number) throws InterruptedException {
        semaphore.acquire();
        System.out.println("teller accepts client number " + number);
        Thread.sleep(random.nextInt(10)*1000);
        System.out.println(number + " released");
        semaphore.release();
    }
}

class MySemaphore {
    private AtomicInteger semaphore;

    public MySemaphore(int semaphore) {
        this.semaphore = new AtomicInteger(semaphore);
    }

    public synchronized void  acquire() throws InterruptedException {
        while (semaphore.get() == 0)
            wait();
        semaphore.decrementAndGet();
    }

    public synchronized void release() {
        semaphore.incrementAndGet();
        this.notify();
    }
}
