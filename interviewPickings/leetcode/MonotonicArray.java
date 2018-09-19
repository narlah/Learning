package interviewPickings.leetcode;

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean asc = false, desc = false;
        int temp;
        for (int i = 1; i < A.length; i++) {
            temp = A[i - 1] - A[i];
            if (temp == 0)
                continue;
            else if (temp > 0) {
                if (desc) continue;
                else if (asc) {
                    return false;
                } else
                    desc = true;
            } else {
                if (asc)
                    continue;
                else if (desc)
                    return false;
                else
                    asc = true;
            }
        }
        return true;
    }
}
