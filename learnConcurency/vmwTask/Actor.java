package learnConcurency.vmwTask;

import java.util.Random;

public class Actor {
    String actorID;
    private Random random = new Random();

    public Actor(String actorID) {
        this.actorID = actorID;
    }

    public void acceptMessage(Message message) throws InterruptedException {
        int waitedFor = random.nextInt(10) * 1000 + 1000;
        String output = "message for : " + message.actorId + " waited :" + waitedFor/1000d + "s " + message.message;
        Thread.sleep(waitedFor);
        System.out.println(output + "... Done!");
    }
}
