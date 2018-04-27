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
        System.out.println(ct.champagneTower(1,1,1));
        System.out.println(ct.champagneTower(2,1,1));
    }
    public double champagneTower(int poured, int query_row, int query_glass) {

        }
}
