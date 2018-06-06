package interviewPickings.leetcode;

/*
1 - 1 top
2 - 1 top + 1/2 2 second row
3 - 3 full - top + 2 second row
4 - 3 full + first 1/4, second 1/2, third 1.4


how much wine to be poured to have nth row full
n is dept , so the number of glasses for the whole tree up until the nth row
that is sum of all is [n(n+1)]/2 glasses are needed
n^2 + n = 2*a
d = [b^2 - sqr(4ac)] / 2
d = (1 - sq(8*a)) / 2

да кажем n 100 чаши

 */
public class ChampaigneTower {
    public static void main(String[] args) {
        ChampaigneTower ct = new ChampaigneTower();
        System.out.println(ct.champagneTower(1000000000, 99, 99)); //.5
        //wtf why 1000000000 is 99/99 is 0 ?!?!?!?!
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0;
        double[] pyramid = new double[5050];
        int[] rowIndexes = new int[100];
        int rowIndex = 0;
        for (int index = 0; index < 100; index++) {
            rowIndex += index;
            rowIndexes[index] = rowIndex;
        }
        pyramid[0] = poured;
        for (int i = 0; i < 99; i++) {
            boolean touched = false;
            for (int j = 0; j <= i; j++) {
                int currentCup = rowIndexes[i] + j;
                int nextCupLeft = rowIndexes[i + 1] + j;
                int nextCupRight = rowIndexes[i + 1] + j + 1;
                double current = pyramid[currentCup];
                if (current > 1) {
                    touched = true;
                    double divide = ((current - 1) / 2);
                    pyramid[nextCupLeft] = pyramid[nextCupLeft] + divide;
                    pyramid[nextCupRight] = pyramid[nextCupRight] + divide;
                }
            }
            if (!touched) break;
        }
        return Math.min(1, pyramid[rowIndexes[query_row] + query_glass]);

    }
//        if (poured >= 5050)
//            return 1;
//        if (poured <= 0)
//            return 0;
//        int rowsFull = getFullRowsDependingOnPoured(poured);
//        int x = rowsFull;
//        if (query_row < rowsFull - 1) //inside the filled range
//            return 1;
//        if (query_row > rowsFull + 1) //outside of possible pouring
//            return 0;
//
//        int cupsFull = (rowsFull * (rowsFull + 1)) / 2;
//        int p = poured - cupsFull; //wine left
//        double k = (double) p / x;
//
//        if (k <= 1 && query_row == x) {
//            if (query_glass == 0 || query_glass == query_row)
//                return k / 2;
//            else
//                return k;
//        }
//        if (k > 1 && query_row == x + 1) {
//            double l = k - 1;
//            if (query_glass == 0 || query_glass == query_row)
//                return l / 2;
//            else
//                return l;
//        }
//        return 0;
//
//    }
//
//    private int getFullRowsDependingOnPoured(int poured) {
//        int left = 1, right = 100, middle;
//        while (true) {
//            middle = (left + right) / 2;
//            int tmp = (middle * (middle + 1)) / 2;
//            if (tmp == poured)
//                return middle;
//            else if (tmp < poured) {
//                left = middle + 1;
//                if (left > right)
//                    return middle;
//            } else {
//                right = middle - 1;
//                if (left > right) {
//                    return middle - 1;
//                }
//            }
//
//        }
//    }
}
