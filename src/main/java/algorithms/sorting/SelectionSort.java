package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    /*
     * Based on the idea that after each iteration, the ith smallest element is going to be in its correct position
     * In each sub-iteration, we keep looking for that element which can be put into its correct place.
     *
     * */
    static int[] arr;

    public SelectionSort(int[] arr) {
        SelectionSort.arr = arr;
    }

    public static void sort() {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j]  < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex);
            }
        }

    }

    public static void swap(int a, int b) {
        System.out.println("Finding a diff between positions:  " + a + " and " + b);
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        System.out.println("After swapping:");
        display();
    }

    public static void display() {
        System.out.println(Arrays.toString(arr));
    }
}
