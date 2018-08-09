package learnConcurency;

public class StaticSyncedClass {
    public static void main(String[] args) {
        Thread t = new Thread(() -> a1.staticMethod(1));
        t.start();
        Thread t2 = new Thread(() -> a1.staticMethod(2));
        t2.start();
        Thread t3 = new Thread(() -> a1.staticMethodTwo(-2));
        t3.start();
        Thread t4 = new Thread(() -> a1.staticMethodTwo(-1));
        t4.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class a1{
    public synchronized static void staticMethod(int key){
        System.out.println("in the synced static method key : " + key);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the synced static method key : " + key);
    }

    public static synchronized void staticMethodTwo(int key){
        System.out.println("In the TWO synched method key: " + key);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exitting the TWO synched method key: " + key);
    }

}