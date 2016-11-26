package archive;

public class MedianOfTwoArraysNotSoSmart {
    public static void main(String[] args) {
        MedianOfTwoArraysNotSoSmart m = new MedianOfTwoArraysNotSoSmart();
        int[] nums1 = {1};// new int[0];// { 1, 3 }; // { 1, 2, 3, 4, 5 };
        int[] nums2 = {4};// new int[0];// { 4, 6 }; // { 6, 7, 8, 9, 10, 11 };
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenCombined = nums1.length + nums2.length;
        int floored = (int) Math.ceil((Double.valueOf(lenCombined) / 2));
        if (lenCombined != 0 && (nums1.length == 0 || nums2.length == 0)) {
            int[] a = nums1.length == 0 ? nums2 : nums1;
            if (a.length % 2 == 0) {
                return Double.valueOf(a[a.length / 2 - 1] + a[a.length / 2]) / 2;
            } else
                return a[a.length / 2];
        }
        System.out.println("floored " + floored + " " + lenCombined / 2);
        int k = 0, l = 0, res1 = 0, res2 = 0;
        while (k <= nums1.length - 1 && l <= nums2.length - 1 && k + l <= floored) {
            res1 = res2;
            if (nums1[k] <= nums2[l]) {
                res2 = nums1[k];
                k++;
            } else {
                res2 = nums2[l];
                l++;
            }
        }
        if (k + l <= floored) {
            System.out.println(k + "-" + l + " res1 " + res1 + " res2 " + res2 + " " + floored);
            if (k < nums1.length) {
                for (int i = k; i < floored - 1; i++) {
                    res1 = res2;
                    res2 = nums1[k];
                    System.out.println("-" + res1 + " " + res2);
                    k++;
                }
            }
            if (l < nums2.length) {
                for (int j = l; j < floored - 1; j++) {
                    res1 = res2;
                    res2 = nums2[j];
                    System.out.println("--" + res1 + " " + res2);
                    l++;
                }
            }
        }
        System.out.println(k + "-" + l + " res1 " + res1 + " res2 " + res2 + " " + floored);
        if (lenCombined % 2 == 0) { // even
            return Double.valueOf(res1 + res2) / 2;
        } else {
            return res1;
        }
    }
}
