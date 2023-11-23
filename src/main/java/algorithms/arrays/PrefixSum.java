package algorithms.arrays;

import java.util.Arrays;

public class PrefixSum {

    //Useful for calculating subarray sums  in O(1) time

    int[] prefixSumArr;

    public PrefixSum(int[] nums) {
        int total = 0;
        prefixSumArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            total += nums[i];
            prefixSumArr[i] = total;

        }
    }

    public int calculateRangeSum(int leftIndex, int rightIndex) {
        if (leftIndex == 0) return prefixSumArr[rightIndex];
        return prefixSumArr[rightIndex] - prefixSumArr[leftIndex - 1];
    }
}
