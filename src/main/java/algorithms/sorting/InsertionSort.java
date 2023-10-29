package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    /*
     * Based on the idea that after each iteration, the ith element is going to be in a sorted order relative to all
     * elements from 0 to i
     * In each sub-iteration, we keep swap elements that are larger than the ith element, so that this element is at
     * the correct index relative to all elements from 0 to index i.
     *
     * Always start at the second element
     *
     * This is a basic sort that could be used when we are clear that the input array is going to be sorted / almost sorted
     * log(n) algos like quick sort are inefficient when the input array is almost sorted
     * */
    private static int[] arr;

    public InsertionSort(int[] arr) {
        InsertionSort.arr = arr;

    }

    public static void sort() {
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                int j = i - 1;
                while (j >= 0 && arr[j] > arr[i]) {
                    j--;
                }
                System.out.println("Insertion needs to happen at position: " + (j + 1));
                if ((j + 1) == i) {
                    System.out.println("Shifting need not be done");
                } else {
                    System.out.println("Shifting needs to be done");
                    shift(arr[i], j + 1, i);
                    display();
                }

            }
        }
    }

    public static void simpleInsertionSort() {
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                int j = i - 1;
                while (j > -1 && arr[j] > arr[j + 1]) {
                    swap(j + 1, j);
                    j--;
                }
                display();
            }
        }
    }

    public static void swap(int firstPosition, int secondPosition) {
        int temp = arr[firstPosition];
        arr[firstPosition] = arr[secondPosition];
        arr[secondPosition] = temp;
    }

    public static void shift(int element, int startPosition, int endPosition) {
        for (int k = endPosition; k > startPosition; k--) {
            arr[k] = arr[k - 1];
        }
        arr[startPosition] = element;
    }

    public static void display() {
        System.out.println(Arrays.toString(arr));
    }
}
