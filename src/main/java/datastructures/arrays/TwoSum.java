package datastructures.arrays;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 4};
        System.out.println(Arrays.binarySearch(nums, 0, nums.length - 1, 2));

    }

//    static int[] twoSumCoordinates(int[] nums, int target) {
//        int markingPtr = 0;
//        int[] twoSumArr = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < target) {
//                markingPtr = i;
//                Arrays.binarySearch(nums, i + 1, nums.length - 1, target - nums[i]);
//            }
//        }
//
//
//        return twoSumArr;
//    }
}
