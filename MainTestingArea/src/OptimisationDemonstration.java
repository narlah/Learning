import java.util.Random;

public class OptimisationDemonstration {

    public static void main(String[] args) {
        int size = 200010;
        int[] values = randomValues(size);
        long start = System.nanoTime();
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        long end = System.nanoTime();

        System.out.println("Time " + (end - start) / 1000 + "ms");
        System.out.println(start);
        System.out.println(end);
        System.out.println(sum);
    }

    static int[] randomValues(int size) {
        int[] result = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(size);
        }
        return result;
    }
}