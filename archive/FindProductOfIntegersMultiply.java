package archive;

import java.util.Arrays;

public class FindProductOfIntegersMultiply {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        FindProductOfIntegersMultiply MainClass = new FindProductOfIntegersMultiply();
        System.out.println(MainClass.printProduct(arr));
    }

    private String printProduct(int[] arr) {
        int len = arr.length;
        String res = checkLen(len);
        if (!res.equals(""))
            return res;

        int[] temp = new int[len];
        temp[0] = 1;
        for (int x = 1, sum = 1; x < arr.length; x++) {
            sum *= arr[x - 1];
            temp[x] = sum;
        }

        for (int y = len - 1, revSum = 1; y >= 0; y--) {
            temp[y] = revSum * temp[y];
            revSum *= arr[y];
        }

        return Arrays.toString(temp);
    }

    private String checkLen(int len) {
        if (len == 0)
            return "Empty list!";
        if (len == 1 || len == 2)
            return "Not suitable list , one or two elements do not really work for this!";
        return "";
    }

}
