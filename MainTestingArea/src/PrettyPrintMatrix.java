import java.util.ArrayList;
import java.util.Arrays;

public class PrettyPrintMatrix {
    public static void main(String[] args) {
        PrettyPrintMatrix sol = new PrettyPrintMatrix();
        sol.printMatrix(sol.prettyPrint(4));
    }

    private ArrayList<ArrayList<Integer>> prettyPrint(int n) {
        int N = 2*n - 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>(0));
        }
        int k = n;

        Integer[] row = new Integer[N];
        for (int i = 0; i <= N / 2; i++) {
            for (int j = i; j < N - i; j++) {
                row[j] = k;
            }
            ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(row));
            matrix.set(i, temp);
            matrix.set(N - i - 1, temp);
            k--;
        }
        return matrix;
    }

    private void printMatrix(ArrayList<ArrayList<Integer>> arrayList) {
        for (ArrayList<Integer> element : arrayList) {
            element.forEach(System.out::print);
            System.out.println();
        }
    }

}