package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    /*
     * Based on the idea that the input array is broken two into half-sized sub-arrays recursively, until a point where
     * each of the sub-arrays have just one element -> a one element array is already sorted.Then we start merging the
     * sorted arrays using a merge function, and finally the entire array is sorted.
     * Space complexity is O(n) at a very high level.
     * Time complexity can be calculated as
     * O(logn) for breaking down the array into single element sub-arrays, and then O(n) for merging 2 sub-arrays
     * Hence the time complexity is O(nlogn)
     * */

    public MergeSort() {
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = (arr.length) / 2;
            return merge(mergeSort(Arrays.copyOfRange(arr, 0, mid)), mergeSort(Arrays.copyOfRange(arr, mid, arr.length)));

        }
        return arr;
    }

    static int[] merge(int[] arr1, int[] arr2) {

        System.out.print("Subarray1: " + Arrays.toString(arr1));
        System.out.println(" Subarray2: " + Arrays.toString(arr2));

        int[] resultArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                resultArray[k++] = arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                resultArray[k++] = arr2[j];
                j++;
            }
        }
        if (i < arr1.length) {
            for (int m = i; m < arr1.length; m++) {
                resultArray[k++] = arr1[m];
            }
        } else if (j < arr2.length) {
            for (int m = j; m < arr2.length; m++) {
                resultArray[k++] = arr2[m];
            }
        }
        return resultArray;
    }

}
