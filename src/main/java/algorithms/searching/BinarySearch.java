package algorithms.searching;

public class BinarySearch {


    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("Mid is " + mid);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static int countNegativeNumbers(int[] arr) {
        //Works only for non-decreasing ordered array
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > 0 && arr[mid + 1] >= 0) {
                low = mid + 1;
            } else if (arr[mid] < 0 && arr[mid + 1] < 0) {
                high = mid - 1;
            } else if (arr[mid] >= 0 && arr[mid + 1] < 0) {
                return mid + 1;
            }
        }
        return -1;
    }

}
