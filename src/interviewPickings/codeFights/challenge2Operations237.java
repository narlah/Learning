package interviewPickings.codeFights;

public class challenge2Operations237 { //failed , did only 30minutes of work tho ...
    public static void main(String[] args) {
        challenge2Operations237 ch = new challenge2Operations237();
        int[] arr = new int[]{79, 0, 1, 3, 5}; //186
        System.out.println(ch.int237(arr));
    }


    int int237(int[] arr) {
        return rec(arr, 1, arr[0], 0);
    }

    int rec(int[] arr, int current, int sum, int count) {
        // Base Cases
        if (sum == 237)
            return 1;
        if (current == arr.length)
            return 0;

        int divideByZero = 0;
        if (arr[current] != 0)
            divideByZero = rec(arr, current + 1, sum / arr[current], count);
        return count +
                rec(arr, current + 1, sum * arr[current], count) +
                rec(arr, current + 1, sum - arr[current], count) +
                rec(arr, current + 1, sum + arr[current], count) +
                divideByZero;
    }

}