package interviewPickings.hackerRank;

import java.util.HashMap;

public class UnionFind<T> { //or DisJointSets
    private HashMap<T, T> parents;
    private HashMap<T, Integer> sizes;
    private int max;

    public UnionFind() {
        parents = new HashMap<>();
        sizes = new HashMap<>();
        max = 0;
    }

    public void union(T v1, T v2) {
        if (!parents.containsKey(v1)) {
            parents.put(v1, v1);
            sizes.put(v1, 1);
        }
        if (!parents.containsKey(v2)) {
            parents.put(v2, v2);
            sizes.put(v2, 1);
        }
        T p1 = find(v1), p2 = find(v2);
        if (p1.equals(p2)) return;
        int s1 = sizes.get(p1), s2 = sizes.get(p2);
        if (s1 > s2) {
            parents.put(p2, p1);
            sizes.put(p1, s1 + s2);
            if (s1 + s2 > max) max = s1 + s2;
        } else {
            parents.put(p1, p2);
            sizes.put(p2, s1 + s2);
            if (s1 + s2 > max) max = s1 + s2;
        }

    }

    private T find(T v) {
        while (parents.get(v) != v) {
            parents.put(v, parents.get(parents.get(v)));
            v = parents.get(v);
        }
        return v;
    }

    //example of use
    static int[] maxCircle(int[][] queries) {
        int[] res = new int[queries.length];
        UnionFind<Integer> unionFind = new UnionFind<>();
        for (int i = 0; i < queries.length; i++) {
            unionFind.union(queries[i][0], queries[i][1]);
            res[i] = unionFind.max;
        }
        return res;
    }
}
