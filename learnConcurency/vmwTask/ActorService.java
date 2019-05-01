package learnConcurency.vmwTask;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ActorService {

    private final Object executorsLock = new Object();
    private AtomicInteger messageCounter = new AtomicInteger(0);
    private int capacity = 5;
    private ConcurrentHashMap<String, Actor> actorRepo = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>> messageQueues = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> actorsLocked = new ConcurrentHashMap<>();

    public ActorService(int capacity) {
        this.capacity = capacity;
        runTheMainLoop();
    }

    public void registerActor(Actor actor) {

        if (!actorRepo.contains(actor)) {
            actorRepo.put(actor.actorID, actor);
            messageQueues.put(actor.actorID, new ConcurrentLinkedQueue<>());
            actorsLocked.put(actor.actorID, false);
        }
    }

    public void sendMessage(Message message) {
        boolean flag = false;

        ConcurrentLinkedQueue<Message> concurrentQueue = messageQueues.get(message.actorId);
        concurrentQueue.add(message);

        if (messageCounter.get() == 0 || concurrentQueue.size() == 1 ) {
            flag = true;
        }

        messageCounter.incrementAndGet();

        if (flag) {
            synchronized (executorsLock) {
                executorsLock.notifyAll();
            }
        }
    }

    private void runTheMainLoop() {
        Executor executor = Executors.newFixedThreadPool(capacity);
        Thread t = new Thread(() -> {
            while (true) {
                if (messageCounter.get() == 0) {
                    try {
                        synchronized (executorsLock) {
                            System.out.println("waiting");
                            executorsLock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (String actorKey : messageQueues.keySet()) {
                    ConcurrentLinkedQueue<Message> actorQueue = messageQueues.get(actorKey);
                    if (!actorsLocked.get(actorKey) && actorQueue.size() > 0) {
                        actorsLocked.put(actorKey, true);
                        final Message message = actorQueue.poll();
                        executor.execute(() -> {
                            try {
                                actorRepo.get(actorKey).acceptMessage(message);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            messageCounter.decrementAndGet();
                            actorsLocked.put(actorKey, false);
                        });
                    }
                }
            }
        });
        t.start();
    }
}
