package learnConcurency.vmwTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ActorService service = new ActorService(5);

        for (int i = 0; i < 10; i++) {
            service.registerActor(new Actor("Actor" + i));
        }

        for (int i = 0; i < 20; i++) {
            service.sendMessage(new Message("Actor" + (i % 10), "message number " + i));
        }
        Thread.sleep(20000);

        for (int i = 100; i < 110; i++) {
            service.sendMessage(new Message("Actor" + (i % 10), "message number " + i));
        }


    }
}
