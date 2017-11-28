package interviewPickings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InFlightEntertainment {

    public static void main(String[] args) {
        int[] movies = {1, 2, 3, 4, 5, 6, 12}; //sorted is important
        final int movieLen = 24;
        System.out.println(checkInFlightPossibility(movies, movieLen));
        System.out.println(checkInFlightPossibilityHashSet(movies, movieLen));
    }

    static boolean checkInFlightPossibility(int[] movies, int movieLen) { //fails the double checking , assuming sorted
        ArrayList<Integer> possibleMatches = new ArrayList<>();
        HashSet originalPossibleMovies = new HashSet();

        for (int movie : movies) {
            if (movie >= movieLen)
                break;
            possibleMatches.add(movieLen - movie);
            originalPossibleMovies.add(movie);
        }
        System.out.println(Arrays.toString(Arrays.copyOf(movies, possibleMatches.size())));
        System.out.println(Arrays.toString(possibleMatches.toArray()));

        for (int elem : possibleMatches) {
            if (originalPossibleMovies.contains(elem)) return true;
        }
        return false;
    }

    static boolean checkInFlightPossibilityHashSet(int[] movies, int movieLen) { //official - we are checking the solution
        HashSet<Integer> mostWanted = new HashSet<>();
        for (int movie : movies) {
            if (movie >= movieLen)
                continue;
            if (mostWanted.contains(movie))
                return true;
            mostWanted.add((movieLen - movie));
        }
        return false;
    }
}
