package learnConcurency;

public class JobCompletedWaitingNotify extends Thread {
    private int counter;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
            try {
                Thread.sleep(1999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.notifyAll();
            System.out.println("Completed Counting ...");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        JobCompletedWaitingNotify job = new JobCompletedWaitingNotify();
        job.start();
        Thread.sleep(1000);
        System.out.println("Waiting to get End ...");
        synchronized (job) {
            job.wait();
        }
        System.out.println(job.counter);
    }

}
