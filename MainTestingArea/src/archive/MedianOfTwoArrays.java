package archive;

public class MedianOfTwoArrays {
    public static void main(String[] args) {
        MedianOfTwoArrays m = new MedianOfTwoArrays();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);
        if (arr.length % 2 == 0) { // even
            int sumOfMiddleAndMiddlePlusOne = arr[arr.length / 2 - 1] + arr[arr.length / 2];
            return (Double.valueOf(sumOfMiddleAndMiddlePlusOne) / 2);
        } else
            return arr[arr.length / 2];
    }

    private static int[] merge(int[] first, int[] second) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        int[] arr = new int[first.length + second.length];
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                arr[j] = first[iFirst];
                iFirst++;
            } else {
                arr[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, arr, j, first.length - iFirst);
        System.arraycopy(second, iSecond, arr, j, second.length - iSecond);
        return arr;
    }
}
