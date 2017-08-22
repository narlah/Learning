package algorithmic.sorts;

import java.util.Date;

public class SelectionSortComponent {
    private int massive[] = null;
    //{ 20, 19, 18, 17, 15, 16, 14, 13, 12, 56, 124, 76, 78, 6, 11, 10, 7, 8, 9, 4, 5, 6,3, 2, 1, 0 };
    private int current_sorted_index = 0;
    private int temp = 0;
    private int index = 0;

    public SelectionSortComponent(int[] array) {
        if (array.length != 0) {
            this.massive = array;
        } else {
            System.out.println("A problem occured while initializing the selection sort! Exiting!");
        }
    }

    public boolean changeArray(int[] array) {
        if (array.length != 0) {
            this.massive = array;
            this.current_sorted_index = 0;
            this.temp = 0;
            this.index = 0;
            return true;
        } else {
            System.out.println("A problem occured while initializing the selection sort! Exiting!");
            return false;
        }
    }

    public int[] sort() {
        while (current_sorted_index < massive.length) {
            index = current_sorted_index;
            for (int i = current_sorted_index; i < massive.length; i++) {
                if (massive[index] > massive[i]) {
                    index = i;
                }
            }
            // replacement
            if (index != current_sorted_index) {
                temp = massive[current_sorted_index];
                massive[current_sorted_index] = massive[index];
                massive[index] = temp;
            }
            // cycle increment , start from next one
            current_sorted_index++;
        }
        System.out.println("Selection sort finished at : " + (new Date()).toString());
        return massive;
    }
}
