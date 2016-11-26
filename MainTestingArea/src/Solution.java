import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.printMatrix(sol.prettyPrint(4));
    }

    public ArrayList<ArrayList<Integer>> prettyPrint(int n) {
        int N = n + n - 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<Integer>(0));
        }
        int k = n;

        Integer[] row = new Integer[N];
        for (int i = 0; i <= N / 2; i++) {
            for (int j = 0 + i; j < N - i; j++) {
                row[j] = k;
            }
            ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(row));
            matrix.set(i, temp);
            matrix.set(N - i - 1, temp);
            k--;
        }
        return matrix;
    }

    public void printMatrix(ArrayList<ArrayList<Integer>> arrayList) {
        for (ArrayList<Integer> element : arrayList) {
            for (Integer t : element) {
                System.out.print(t);
            }
            System.out.println();
        }
    }

}