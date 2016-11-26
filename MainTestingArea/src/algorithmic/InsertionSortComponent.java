package algorithmic;

import java.util.Date;

public class InsertionSortComponent {
    private int massive[] = null;

    //{ 20, 19, 18, 17, 15, 16, 14, 13, 12, 56, 124, 76, 78, 6, 11, 10, 7, 8, 9, 4, 5, 6,3, 2, 1, 0 };
    public InsertionSortComponent(int[] array) {
        if (array.length != 0) {
            this.massive = array;
        } else {
            System.out.println("A problem occured while initializing the selection sort! Exiting!");
        }
    }

    public boolean changeArray(int[] array) {
        if (array.length != 0) {
            this.massive = array;
            return true;
        } else {
            System.out.println("A problem occured while initializing the selection sort! Exiting!");
            return false;
        }
    }

    public int[] sort() {
        for (int i = 1; i < massive.length; i++) {
            int j = i;
            while (j > 0 && massive[j - 1] > massive[j]) {
                int temp = massive[j - 1];
                massive[j - 1] = massive[j];
                massive[j] = temp;
                j--;
            }
        }
        System.out.println("Insertion sort finished at : " + (new Date()).toString());
        return massive;
    }
}
