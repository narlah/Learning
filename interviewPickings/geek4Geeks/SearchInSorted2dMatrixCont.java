package interviewPickings.geek4Geeks;

import java.util.Arrays;

public class SearchInSorted2dMatrixCont {

    public String search(int[][] arr, int searchFor) {
        int colMax = arr.length - 1;
        int rowMax = arr[0].length - 1;
        int left = 0, right = colMax;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid][0] <= searchFor && arr[mid][rowMax] >= searchFor) {
                int temp = Arrays.binarySearch(arr[mid], searchFor);
                return temp == -1 ? "-1" : "Found at (" + mid + " , " + temp + ")";
            }
            if (arr[mid][0] > searchFor) {
                right = mid - 1;
                continue;
            }
            if (arr[mid][rowMax] < searchFor) {
                left = mid + 1;
                continue;
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]
                {
                        {1, 5, 9, 11},
                        {14, 20, 21, 26},
                        {30, 34, 43, 50}
                };
        SearchInSorted2dMatrixCont ss = new SearchInSorted2dMatrixCont();
        System.out.println(ss.search(mat, 21));
        System.out.println(ss.search(mat, 88));
    }
}


/*
        System.out.println(ss.search(mat, 50));
        System.out.println(ss.search(mat, 1));
        System.out.println(ss.search(mat, 11));
        System.out.println(ss.search(mat, 34));
 */