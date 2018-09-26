package learnConcurency.vmwTask;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ActorService {

    private ConcurrentHashMap<String, Actor> actorRepo = new ConcurrentHashMap<>();

    public void registerActor(Actor actor) {
        if (!actorRepo.contains(actor)){
            actorRepo.put(actor.actorID,actor);
        }
    }

    public void sendMessage(Message message) {

    }
}
