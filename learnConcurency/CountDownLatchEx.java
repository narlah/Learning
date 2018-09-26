package learnConcurency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    public static void main(String[] args) {
        final CountDownLatch countdown = new CountDownLatch(1);
        for (int i = 0; i < 10; ++ i){
            Thread racecar =  new Thread(() -> {
                try {
                    countdown.await(); //all threads waiting
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Vroom!");
            });
            racecar.start();
        }
        System.out.println("Go");
        countdown.countDown();   //all threads start now!
    }

}
