package algorithmic.sorts;

//import java.util.Arrays;
//import algorithmic.sorts.MergeSortComponent;

import java.util.Arrays;

public class SortTester {

    public static void main(String[] args) {
        // ***************************f6**********************************
        int[] massive = {20, 19, 18, 17, 15, 16, 16, 16, 1714, 13, 12, 56, 124, 76, 78, 6, 11, 10, 7, 8, 9, 4, 5, 6, 3, 2, 1, 0};
        // InsertionSortComponent insertionSort = new InsertionSortComponent(massive);
        // System.out.println(Arrays.toString(insertionSort.sort()));

        int[] res = MergeSortComponent.sort(massive);
        System.out.println(Arrays.toString(res));
        System.out.println(res.length + " =?= " + massive.length);
         QuickSortComponent quickSort = new QuickSortComponent();
         System.out.println(Arrays.toString(quickSort.sort(massive)));

        // ***************************************************************
    }

}
