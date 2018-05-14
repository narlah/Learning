package interviewPickings.codeFights;

public class adjasmentElementProduct {
    public static void main(String[] args) {
        adjasmentElementProduct adj = new adjasmentElementProduct();
        int[] arr = new int[]{3, 6, -2, -5, 7, 3};
        System.out.println(adj.adjacentElementsProduct(arr));
    }

    int adjacentElementsProduct(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= inputArray.length - 2; i++) {
            int tmpMax = inputArray[i]*inputArray[i+1];
            if (tmpMax>max) max = tmpMax;
        }
        return max;
    }

}
