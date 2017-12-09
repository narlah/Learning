package archive;

public class TradeAppleStock {
    private static final int[] arr = {10000, 1, 2, 200, 3, 4, 5, 6, 100, 14000, 1000, 1110, 2, 15, 6, 150, 5000, 0, 12, 6, 14, 200, 10001};

    public static void main(String[] args) {
        MinMaxSum res = gatherTradeMinMax(0, arr.length - 1);
        System.out.println(res.toString() + " || ranges :  " + arr[res.min] + " " + arr[res.max]);
        System.out.println("maxProfitOnly         sum=" + gatherMaxProfitOnly());
    }

    private static MinMaxSum gatherTradeMinMax(int i, int j) {
        MinMaxSum minMaxArr = findMinMax(i, j);
        if (minMaxArr.min <= minMaxArr.max || minMaxArr.sum <= 0)
            return minMaxArr;
        MinMaxSum firstMinMaxArr = gatherTradeMinMax(i, minMaxArr.max); // here you can think of something to get only min
        MinMaxSum secondMinMaxArr = gatherTradeMinMax(minMaxArr.max + 1, j); // get only max TODO
        return firstMinMaxArr.sum > secondMinMaxArr.sum ? firstMinMaxArr : secondMinMaxArr;
    }

    private static MinMaxSum findMinMax(int i, int j) {

        int min = i, max = i;
        for (int k = i; k <= j; k++) {
            if (arr[k] < arr[min])
                min = k;
            if (arr[k] >= arr[max])
                max = k;
        }

        return new MinMaxSum(min, max, arr[max] - arr[min]);
    }

    private static int gatherMaxProfitOnly() {
        int maxProfit = 0;
        int minPrice = arr[0];
        for (int currentPrice : arr) {
            maxProfit = Math.max(maxProfit, currentPrice - minPrice);
            minPrice = Math.min(currentPrice, minPrice);
        }
        return maxProfit;
    }
}

class MinMaxSum {
    int min;
    int max;
    int sum;
    public MinMaxSum(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }

    public String toString() {
        return "minIndex=" + min + " maxIndex=" + max + " sum=" + sum;
    }
}