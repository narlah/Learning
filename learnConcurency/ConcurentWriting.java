package learnConcurency;

public class ConcurentWriting {
    private synchronized void increment(int i) {
        this.count += i;
    }

    private int count = 0;
    //volatile did not help ...
    //normal int is not suitable , atomicInteger works
    //synchronised works as well


    public static void main(String[] args) throws InterruptedException {
        ConcurentWriting cw = new ConcurentWriting();
        cw.doTheThing();
    }

    private void doTheThing() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment(1);
            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment(2);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //Thread.sleep(2000);
        System.out.println(count);

    }
}
