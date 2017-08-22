package algorithmic.sorts;

public class heap_Sort {
    public static void main(String a[]) {
        int arr[] = {1, 3, 4, 5, 2};

        for (int i = arr.length; i > 1; i--) {
            fnSortHeap(arr, i - 1);
        }
    }

    private static void fnSortHeap(int array[], int arr_ubound) {
        int i, o;
        int lChild, rChild, mChild, root, temp;
        root = (arr_ubound - 1) / 2;

        for (o = root; o >= 0; o--) {
            for (i = root; i >= 0; i--) {
                lChild = (2 * i) + 1;
                rChild = (2 * i) + 2;
                if ((lChild <= arr_ubound) && (rChild <= arr_ubound)) {
                    if (array[rChild] >= array[lChild])
                        mChild = rChild;
                    else
                        mChild = lChild;
                } else {
                    if (rChild > arr_ubound)
                        mChild = lChild;
                    else
                        mChild = rChild;
                }
                // swap array[i] and array[child] in case the child is bigger
                if (array[i] < array[mChild]) {
                    temp = array[i];
                    array[i] = array[mChild];
                    array[mChild] = temp;
                }
            }
        }
        //swap array[0] and array[arr_unbound]
        temp = array[0];
        array[0] = array[arr_ubound];
        array[arr_ubound] = temp;
    }
}