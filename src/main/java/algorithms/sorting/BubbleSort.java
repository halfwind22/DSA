package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    static int[] arr;

    public BubbleSort(int[] arr) {
        BubbleSort.arr = arr;
    }

    public static void sort() {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < (arr.length - 1) - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
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
