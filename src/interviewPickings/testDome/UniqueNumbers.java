package interviewPickings.testDome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        for (int next : numbers) {
            if (duplicates.contains(next)) continue;
            if (result.contains(next)) {
                result.remove(next);
                duplicates.add(next);
                continue;
            }
            result.add(next);
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 1, 2, 3, 4, 5, 78, 100, 100, 200, 200, 201);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}