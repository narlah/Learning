package archive;


public class EquilibriumArrayIndex {
    public static int solution(int[] A) {
        int leftIndex = 0;
        int rightIndex = A.length - 1;
        if (A.length == 0) { //empty array
            return -1;
        }
        if (leftIndex == rightIndex) { //one element
            return leftIndex;
        }
        long rightSum = A[rightIndex], leftSum = A[0];
        leftIndex = 0;
        while ((rightIndex - leftIndex) > 1) {
            if ((leftSum > rightSum && leftSum + A[leftIndex + 1] < rightSum) || leftSum < rightSum) {
                leftSum += A[++leftIndex];
            } else if ((rightSum > leftSum && leftSum < rightSum + A[rightIndex - 1]) || leftSum > rightSum) {
                rightSum += A[--rightIndex];
            } else if (leftSum == rightSum && (rightIndex - leftIndex) > 2) {
                leftSum += A[++leftIndex];
            } else if (!(leftIndex == rightIndex - 1 && (rightIndex == A.length - 1))) {
                break;
            }
        }
        if (leftSum == rightSum && leftIndex != rightIndex - 1) {
            return leftIndex + 1;
        } else if (leftSum == rightSum && rightIndex == A.length - 1) {
            return rightIndex;
        } else if (leftSum == rightSum && leftIndex == 0) {
            return leftIndex;
        } else
            return -1;

    }

    public static void main(String args[]) {
        System.out.println(solution(new int[]{1, 2, 1})); //1
        System.out.println(solution(new int[]{-10, 50, 2, 7, 30, 12})); //3
        System.out.println(solution(new int[]{1, 1, 5, 100, 13, 12, 13, 107})); //5
        System.out.println(solution(new int[]{100, 0, 7, 63, 30}));//1
        System.out.println(solution(new int[]{-7, 1, 5, 2, -4, 3, 0}));//6
        System.out
                .println(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));//10
        System.out.println(solution(new int[]{0, +2147483647, -2147483647})); //0
    }
}
