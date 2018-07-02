package learnConcurency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerDeadlock {
    private Account act1 = new Account();
    private Account act2 = new Account();
    Random random = new Random();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    //private Condition cond = lock.newCondition();


    //always acquire locks - avoiding the deadlock
    private void aquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        while (true) {
            //Try to Acquire the locks
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) {
                    return;
                }
                if (gotFirstLock) {
                    firstLock.unlock();
                }
                if (gotSecondLock) {
                    secondLock.unlock();
                }
            }
            lock1.lock();
            lock2.lock();
            //Locks not acquired
            Thread.sleep(1);
        }
    }

    private void firstThread() throws InterruptedException {
        try {
            aquireLocks(lock1, lock2);
            for (int i = 0; i < 10000; i++) {
                Account.transfer(act1, act2, random.nextInt(100));
            }
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    private void secondThread() throws InterruptedException {
        try {
            aquireLocks(lock2, lock1);
//            lock1.lock(); //switch here and it will block
//            lock2.lock(); //always lock in the same order
            for (int i = 0; i < 10000; i++) {
                Account.transfer(act2, act1, random.nextInt(100));
            }
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    private void finish() {
        System.out.println("A1 balance :" + act1.getBalance());
        System.out.println("A2 balance :" + act2.getBalance());
        System.out.println("Total balance : " + (act1.getBalance() + act2.getBalance()));
    }

    public static void main(String[] args) {
        final RunnerDeadlock runner = new RunnerDeadlock();
        Thread t1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                runner.secondThread();
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
        runner.finish();
    }
}
