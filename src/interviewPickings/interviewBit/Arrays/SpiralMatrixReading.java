package interviewPickings.interviewBit.Arrays;


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixReading {


    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int left = 0;
        int bottom = A.size() - 1;
        int right = A.get(top).size() - 1;
        int direction = 0;
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = top; i <= right; i++)
                    result.add(A.get(top).get(i));
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++)
                    result.add(A.get(i).get(right));
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--)
                    result.add(A.get(bottom).get(i));
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--)
                    result.add(A.get(i).get(left));
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }

}
