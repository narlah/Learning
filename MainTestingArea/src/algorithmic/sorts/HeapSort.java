//Source code for Heap Sort 
package algorithmic.sorts;

public class HeapSort {
    private static int[] a;
    private static int n;

    private static void buildheap(int[] a) { //initially builds heap
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(a, i);
        }
    }

    private static void maxheap(int[] a, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest;
        if (left <= n && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    private static void exchange(int i, int j) { //simple swap i<->j
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(int[] a0) { //the sort method
        a = a0;
        buildheap(a); //builds heap at first

        for (int i = n; i > 0; i--) {
            exchange(0, i); //swap
            n = n - 1;
            maxheap(a, 0); //rearrange heap ?
        }
    }

    public static void main(String[] args) { //testing main
        int[] a1 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};  //example array
        sort(a1); //calling main sort method, returns nada uses global array pointer and work on it
        for (int anA1 : a1) { //print out
            System.out.print(anA1 + " ");
        }
    }
}