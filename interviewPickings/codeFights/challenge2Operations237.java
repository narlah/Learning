package interviewPickings.codeFights;

public class challenge2Operations237 {
    public static void main(String[] args) {
        challenge2Operations237 ch = new challenge2Operations237();
        int[] arr = new int[]{79, 0, 1, 3, 5}; //186
        System.out.println(ch.int237(arr));
    }


    int int237(int[] arr) {
        return rec(arr, 1, arr[0], arr[0] + "");
    }

    int rec(int[] arr, int current, int sum, String op) {
        if (current == arr.length) {
            System.out.println(op + " = " + sum);
            return sum == 237 ? 1 : 0;
        }

        return rec(arr, current + 1, sum * arr[current], op + "*" + arr[current]) +
                rec(arr, current + 1, sum - arr[current], op + "-" + arr[current]) +
                rec(arr, current + 1, sum + arr[current], op + "+" + arr[current]) +
                (arr[current] != 0 ? rec(arr, current + 1, sum / arr[current], op + "/" + arr[current]) : 0);
    }
}