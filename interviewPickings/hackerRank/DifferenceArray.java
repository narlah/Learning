package interviewPickings.hackerRank;

public class DifferenceArray {
    //Starting with a 1-indexed array of zeros and a list of operations,
// for each operation add a value to each of the array element between two given indices, inclusive.
// Once all operations have been performed, return the maximum value in your array.
    static long arrayManipulation(int n, int[][] queries) {
        long[] diff = new long[n + 2];
        for (int[] query : queries) {
            diff[query[0]] += query[2]; //a,b,k
            diff[query[1] + 1] -= query[2];
        }
        long max = 0;
        long current = 0;
        for (long i : diff) {
            current += i;
            if (current > max)
                max = current;
        }
        return max;
    }
}
