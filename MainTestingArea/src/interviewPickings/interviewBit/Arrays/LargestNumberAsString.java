package interviewPickings.interviewBit.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumberAsString {

    public static void main(String[] args) {
        LargestNumberAsString lar = new LargestNumberAsString();
        //int[] arr = new int[]{12, 121};
        int[] arr = new int[]{Integer.MAX_VALUE, 7};
        //int[] arr = new int[]{931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615, 638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747, 743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322};
        System.out.println("12,121   <-> " + lar.largestNumber(arr));

    }

    public String largestNumber(final int[] A) {
        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());
        arr.sort((o1, o2) -> (Double.valueOf(o2 + "" + o1).compareTo(Double.valueOf(o1 + "" + o2))));

        StringBuilder sb = new StringBuilder();
        long sumSoFar = 0;
        for (int i : arr) {
            if (i == 0 && sumSoFar == 0) continue;
            sumSoFar += i;
            sb.append(i);
        }
        if (sumSoFar == 0) return "0";
        return sb.toString();
    }
}
