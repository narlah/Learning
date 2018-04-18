package interviewPickings;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {
    public static void main(String[] args) {
        long tStart = System.nanoTime();
        int[] deck = new int[53];
        for (int i = 1; i <= 52; i++) {
            deck[i] = i;
        }
        Hashtable<Long, int[]> attempts = new Hashtable<>();
        int flag = 0;
        for (int i = 0; i < 10_000_000L; i++) {
            if (flag == 50000) {
                Runtime rt = Runtime.getRuntime();
                System.out.println("--------------- " + i + " ---------------> " + (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024 + "MB");
                flag = 0;
            }
            flag++;
            int[] newDeck = deck.clone();
            shuffleArray(newDeck);
            long hash = 0;
            for (int j = 0; j < 10; j++) {
                hash += newDeck[j] * (j * 10);
            }
            if (attempts.contains(hash)) {
                System.out.println("Collision !!! : " + Arrays.toString(newDeck) + "  " + Arrays.toString(attempts.get(hash)));
                break;
            }
            // System.out.println(hash + " " + Arrays.toString(newDeck) );
            attempts.put(hash, newDeck.clone());
        }
        System.out.println("Time " + ((System.nanoTime() - tStart) / 1_000_000_000.0));
    }

    static void shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
