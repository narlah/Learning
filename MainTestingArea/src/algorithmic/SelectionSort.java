package algorithmic;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String arg[]) {
        int massive[] = {20, 19, 18, 17, 15, 16, 14, 13, 12, 56, 124, 76, 78, 6, 11, 10, 7, 8, 9, 4, 5, 6,
                3, 2, 1, 0};
        int current_sorted_index = 0;
        int temp = 0;
        int index = 0;
        while (current_sorted_index <= massive.length - 1) {
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
        System.out.println(Arrays.toString(massive));
    }
}
