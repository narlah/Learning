import java.util.ArrayList;

public class FlipBitsVMware {
    public static void main(String[] args) {
        FlipBitsVMware a = new FlipBitsVMware();
        System.out.println(a.flip("111110001111001"));
    }

    private ArrayList<Integer> flip(String A) {
        int[] a = new int[A.length()];
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '1')
                a[i] = 1;
            else
                a[i] = 0;
        }
        int maxDiff = 0;
        int flipStartIndex = 0;
        int flipEndIndex = 0;

        int currentDiff = 0;
        int currentStart = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
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
        if (maxDiff == 0 && flipStartIndex == 0) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(flipStartIndex + 1);
        result.add(flipEndIndex + 1);
        return result;
    }
}
