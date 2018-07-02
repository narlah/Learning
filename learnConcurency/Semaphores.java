package learnConcurency;

import java.util.concurrent.Semaphore;

public class Semaphores {
    public static void main(String[] args) throws Exception {
        Semaphore sem = new Semaphore(1);


        sem.release();
        sem.acquire();


        System.out.println("Available : " + sem.availablePermits());

    }
}
