package learnConcurency.vmwTask;

import java.util.Random;

public class Actor {
    public String actorID;
    Random random = new Random();

    public Actor(String actorID) {
        this.actorID = actorID;
    }

    public void acceptMessage(Message message) throws InterruptedException {
        int waitedFor = random.nextInt(5) * 1000 + 1000;
        System.out.println("message for : " + message.actorId + " waited :" + waitedFor + " " + message.message);
        Thread.sleep(waitedFor);
    }
}
