import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

public class FindPairsInIntArray {
    private static int searchForSum = 8;

    private static boolean checkForPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length && i != j; j++) {
                if (arr[i] + arr[j] == searchForSum) return true;
            }
        }
        return false;
    }

    private static boolean checkForPairsAdvanced(int[] arr) {
        if (arr.length == 1) return false; //we need pairs
        int i = 0, j = arr.length - 1, sum;

        while (i < j) {
            sum = arr[i] + arr[j];
            if (sum == searchForSum)
                return true;
            if (sum < searchForSum)
                i++;
            else
                j--;

        }
        return false;
    }

    private static boolean checkForPairsHash(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        //int current;
        for (int anArr : arr) {
            if (set.contains(anArr)) return true;
            set.add(searchForSum - anArr);
        }
        return false;
    }

    public static void main(String[] args) {
        //FindPairsInIntArray f = new FindPairsInIntArray();
        List<int[]> initialData = new ArrayList<>();

        initialData.add(new int[]{-1, -1, 2, 3, 9});
        initialData.add(new int[]{1, 2, 4, 4});
        initialData.add(new int[]{});
        initialData.add(new int[]{1});
        initialData.add(new int[]{0, 0});
        initialData.add(new int[]{0, -1});
        initialData.add(new int[]{0, 4, 0, 4});
        check(FindPairsInIntArray::checkForPairs, initialData);
        check(FindPairsInIntArray::checkForPairsAdvanced, initialData);
        check(FindPairsInIntArray::checkForPairsHash, initialData);
    }

    private static void check(Function<int[], Boolean> f, List<int[]> initialData) {
        System.out.println(f); //still wondering how to get the name of the Function , but its freaking 2am , good night
        for (int[] data : initialData) {
            System.out.println(Arrays.toString(data) + " " + f.apply(data));
        }
        System.out.println("-----------------------");
    }

}

