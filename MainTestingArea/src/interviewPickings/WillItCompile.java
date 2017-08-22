package interviewPickings;

public class WillItCompile extends Thread {
    private int counter;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100000; i++) {
                counter++;
            }

            this.notifyAll();
            System.out.println("Completed Counting ...");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WillItCompile job = new WillItCompile();
        job.start();
        Thread.sleep(1000);
        System.out.println("Waiting to get End ...");
        job.wait();
        System.out.println(job.counter);
    }

}
