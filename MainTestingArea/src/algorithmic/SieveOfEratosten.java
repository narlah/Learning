package algorithmic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SieveOfEratosten {

    public static List<Integer> findPrimes(int limit) {

        List<Integer> list = new ArrayList<Integer>();

        boolean[] isComposite = new boolean[limit + 1]; // limit + 1 because we won't use '0'th index of the array
        isComposite[1] = true;

        // Mark all composite numbers
        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                // 'i' is a prime number
                list.add(i);
                int multiple = 2;
                while (i * multiple <= limit) {
                    isComposite[i * multiple] = true;
                    multiple++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = findPrimes(1000);
        Iterator<Integer> iterator = list.iterator();
        int j = 0;
        while (iterator.hasNext()) {
            System.out.printf("%,8d ", iterator.next());
            if (++j % 10 == 0) {
                System.out.println();
            }
            if (j % 150 == 0) {
                System.out.println();
            }

        }
    }
}
