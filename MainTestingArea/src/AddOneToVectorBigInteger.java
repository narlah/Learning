import java.util.ArrayList;
import java.util.Arrays;

//import java.math.BigInteger;
public class AddOneToVectorBigInteger {

    public static void main(String[] args) {
        AddOneToVectorBigInteger a = new AddOneToVectorBigInteger();
        System.out.println(a.plusOne(new ArrayList<>(Arrays.asList(0, 8, 9, 9, 1))));
    }

    private ArrayList<Integer> plusOne(ArrayList<Integer> in) {
        int carry = 1;
        int[] result = new int[in.size() + 1];
        for (int i = in.size() - 1; i >= -1; i--) {
            if (i == -1) {
                result[0] = carry;
                break;
            }
            int temp = in.get(i) + carry;
            if (temp > 9) {
                carry = 1;
                result[i + 1] = temp % 10;
            } else {
                carry = 0;
                result[i + 1] = temp;
            }
        }
        int zeroIndex = 0;
        while (result[zeroIndex] == 0 && zeroIndex < result.length - 1) {
            zeroIndex++;

        }
        ArrayList<Integer> resultArray = new ArrayList<>();
        for (int i = zeroIndex; i < result.length; i++) {
            resultArray.add(result[i]);
        }
        return resultArray;
    }
}
