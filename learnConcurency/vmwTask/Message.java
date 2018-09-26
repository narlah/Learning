package learnConcurency.vmwTask;

public class Message {
    String actorId;
    String fromActorId;
    String message;

    @Override
    public String toString() {
        return "Message{" +
                "actorId='" + actorId + '\'' +
                ", fromActorId='" + fromActorId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
