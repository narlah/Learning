package interviewPickings;

import java.util.List;

public class FindMaxSumSubArray {
    // DO NOT MODFIY THE LIST.
    public int maxSubArray(List<Integer> C) {
        int newsum = C.get(0);
        int maxCurrent = C.get(0);
        for (int i = 1; i < C.size(); i++) {
            newsum = Math.max(newsum + C.get(i), C.get(i));
            maxCurrent = Math.max(maxCurrent, newsum);
        }
        return maxCurrent;
    }
}
