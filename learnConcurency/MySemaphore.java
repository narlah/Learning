package learnConcurency;

import java.util.concurrent.atomic.AtomicInteger;

public class MySemaphore {

    private AtomicInteger semaphore;

    public MySemaphore(int semaphore) {
        this.semaphore = new AtomicInteger(semaphore);
    }

    public synchronized void acquire() throws InterruptedException {
        while (semaphore.get() == 0)
            wait();
        semaphore.decrementAndGet();
    }

    public synchronized void release() {
        semaphore.incrementAndGet();
        this.notify();
    }
}
