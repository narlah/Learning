package interviewPickings;

import java.util.ArrayList;
import java.util.Arrays;

public class SolitionInfiniteGraphRouting {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static void main(String[] args) {
        ArrayList<Integer> Xses = new ArrayList<Integer>(Arrays.asList(1, -3, 150));
        ArrayList<Integer> Yses = new ArrayList<Integer>(Arrays.asList(1, -3, 500));
        SolitionInfiniteGraphRouting sol = new SolitionInfiniteGraphRouting();
        System.out.println(sol.coverPoints(Xses, Yses));
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int dist = 0;
        for (int i = 0; i < X.size() - 1; i++) {
            dist += getDistance(X.get(i), Y.get(i), X.get(i + 1), Y.get(i + 1));
        }
        return dist;
    }

    public int getDistance(int x1, int y1, int x2, int y2) {
        int xNorm = Math.abs(x2 - x1);
        int yNorm = Math.abs(y2 - y1);
        return Math.max(xNorm, yNorm);
    }

}
