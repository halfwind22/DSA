package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    /*
     * Based on the idea of a pivot such that, after each iteration the pivot element is in its correct location in
     * the array . All elements to the left of the pivot are smaller than the pivot and all element to the right of
     * the pivot are greater than the pivot.
     * Then recursively apply quick sort to the sub-arrays on the left and right of the pivot, until the startPosition is
     * less than the endPosition->meaning there are at least 2 items to be sorted within the sub-array.
     * Space complexity is O(1) as no extra space is consumed.
     * Time complexity can be calculated as
     * O(n) for figuring out the pivot in each iteration
     * O(logn) for breaking down the array until upto single element sub-arrays.
     * Hence, the time complexity is O(nlogn) on best/average case where the input array is thoroughly shuffled
     * Worst case being O(n2) when the input array is fully sorted as each sub-array will have almost n elements to be
     * checked for finding pivot position.
     *
     * */


    public QuickSort() {
    }

    public static void quickSort(int[] arr, int startPosition, int endPosition) {
        if (startPosition < endPosition) {
            int pivotPosition = findPivot(arr, startPosition, endPosition);
            System.out.println("Pivot found at position: " + pivotPosition);
            display(arr);
            quickSort(arr, startPosition, pivotPosition - 1);
            quickSort(arr, pivotPosition + 1, endPosition);

        }
    }

    private static int findPivot(int[] arr, int pivotPosition, int endPosition) {
        int swapIndex = pivotPosition;
        for (int i = pivotPosition + 1; i <= endPosition; i++) {
            if (arr[i] < arr[pivotPosition]) {
                swap(arr, ++swapIndex, i);
            }
        }
        swap(arr, pivotPosition, swapIndex);
        return swapIndex;

    }

    public static void swap(int[] arr, int firstPosition, int secondPosition) {
        int temp = arr[firstPosition];
        arr[firstPosition] = arr[secondPosition];
        arr[secondPosition] = temp;
    }

    public static void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
