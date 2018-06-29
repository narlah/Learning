package learnConcurency;

import java.util.Scanner;

public class ProcessorHello {
    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }

    private volatile boolean shutdown = false;

    class Cpu implements Runnable {
        @Override
        public void run() {
            while (!shutdown) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello");
            }
        }
    }

    void r() {
        Thread t = new Thread(new Cpu());
        t.start();

        System.out.println("Hit Enter to stop it ...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        setShutdown(true);

        System.out.println("finally");
    }

    public static void main(String[] args) {
        ProcessorHello p = new ProcessorHello();
        p.r();
    }
}
