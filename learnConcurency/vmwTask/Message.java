package learnConcurency.vmwTask;

public class Message {
    String actorId;
    String fromActorId;
    String message;

    public Message(String actorId, String message) {
        this.actorId = actorId;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "actorId='" + actorId + '\'' +
                ", fromActorId='" + fromActorId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
