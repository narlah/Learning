package learnConcurency;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        //In case we don't want to return anything , but just receive exceptions
        //Future<?> future = executor.submit(new Callable<Void>() {
        //@Override
        //public Void call() throws Exception {
        Future<Integer> future = executor.submit(() -> {
            Random random = new Random();
            int duration = random.nextInt(4000);
            if (duration > 2000) {
                throw new IOException("Sleeping too long");
            }
            System.out.println("Starting ...");

            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished.");
            return duration; //return null
        });
        executor.shutdown();
        //executor.awaitTermination()

        try {
            System.out.println("Future is : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) { //<- will be thrown here
            IOException ex = (IOException) e.getCause();
            System.out.println(e);
            ex.printStackTrace();
        }


        //        executor.submit(()-> {
//           Random random = new Random();
//           int duration = random.nextInt(4000);
//            System.out.println("Starting ...");
//
//            try{
//                Thread.sleep(duration);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println("Finished.");
    }
}
