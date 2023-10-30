package datastructures.arrays;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSumCoordinates(int[] nums, int target) {
        int markingPtr = 0;
        int[] twoSumArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            markingPtr = i;
            int result = linearSearch(nums, i + 1, nums.length, target - (nums[i]));
            if (result > -1) {
                twoSumArr[0] = markingPtr;
                twoSumArr[1] = result;
                return twoSumArr;
            }
        }

        return twoSumArr;
    }

    public static int[] twoSumCoordinatesUsingHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        int markingPtr = 0;
        for (int i = 0; i < nums.length; i++) {
            markingPtr = i;
            if (numberMap.get(target - (nums[i])) != null) {
                return new int[]{markingPtr, numberMap.get(target - (nums[i]))};
            } else {
                numberMap.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }

    static int linearSearch(int[] arr, int startPosition, int endPosition, int key) {
        for (int i = startPosition; i < endPosition; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
