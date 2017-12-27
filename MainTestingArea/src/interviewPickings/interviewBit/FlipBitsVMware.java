package interviewPickings.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class FlipBitsVMware {
    public static void main(String[] args) {
        FlipBitsVMware a = new FlipBitsVMware();
        System.out.println(a.flip("111110001111001"));
    }

    public ArrayList<Integer> flip(String A) {
        ArrayList<Character> aArr = new ArrayList<>();
        A.chars().forEach(c -> aArr.add((char) c));

        int maxDiff = 0, flipStartIndex = 0, flipEndIndex = 0, currentDiff = 0, currentStart = 0;

        for (int i = 0; i < aArr.size(); i++) {
            if (aArr.get(i) == '0') {
                currentDiff -= 1;
            } else {
                currentDiff += 1;
            }
            if (currentDiff < maxDiff) {
                maxDiff = currentDiff;
                flipStartIndex = currentStart;
                flipEndIndex = i;
            } else if (currentDiff > 0) {
                currentDiff = 0;
                currentStart = i + 1;
            }
        }
        return (maxDiff == 0 && flipStartIndex == 0) ? new ArrayList<>() :
                new ArrayList<>(Arrays.asList(flipStartIndex + 1, flipEndIndex + 1));
    }
}
