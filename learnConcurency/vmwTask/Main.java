package learnConcurency.vmwTask;

public class Main {
    public static void main(String[] args) {
        ActorService service = new ActorService();

        for (int i = 0; i < 10; i++) {
            service.registerActor(new Actor("Actor"+i));
        }
    }
}
