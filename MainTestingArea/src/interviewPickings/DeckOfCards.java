package interviewPickings;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {
    public static void main(String[] args) {
        long tStart = System.nanoTime();
        System.out.println(13280 + " " + getHash(new int[]{13, 47, 36, 21, 19, 14, 40, 42, 2, 50, 1, 51, 28, 27, 5}));
        System.out.println(13280 + " " + getHash(new int[]{31, 18, 40, 52, 32, 22, 50, 26, 42, 2, 34, 6, 25, 29, 16}));
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
            long hash = getHash(newDeck);
            if (attempts.containsKey(hash)) {
                System.out.println("Collision !!! : \n " + hash + " \n " + Arrays.toString(newDeck) + " \n " + Arrays.toString(attempts.get(hash)));
                System.out.println(getHash(Arrays.copyOfRange(newDeck, 0, 10)));
                System.out.println(getHash(Arrays.copyOfRange(attempts.get(hash), 0, 10)));
                break;
            }
            // System.out.println(hash + " " + Arrays.toString(newDeck) );
            attempts.put(hash, newDeck.clone());
        }
        System.out.println("Time " + ((System.nanoTime() - tStart) / 1_000_000_000.0));
    }

    private static long getHash(int[] newDeck) {
        long hash = 0;
        for (int j = 0; j < 10; j++) {
            hash += newDeck[j] * (j * 10);
        }
        return hash;
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
