package interviewPickings.hackerRank;

public class RecursiveStairCase {

    static int stepPerms(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        //return stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3);
        int[] ways = new int[]{1, 2, 4};

        for (int i = 4; i < n; i++) {
            int idx = (i - 1) % 3;
            ways[idx] = ways[0] + ways[1] + ways[2];
        }
        return ways[0] + ways[1] + ways[2];

    }

    public static void main(String[] args) {
        System.out.println(stepPerms(5));
    }
}
