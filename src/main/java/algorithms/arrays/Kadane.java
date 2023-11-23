package algorithms.arrays;

import java.util.Arrays;

public class Kadane {
    /*
     * Non-empty sub array resulting in the largest sum
     * What are we trying to do?
     * If a previous sum until a certain point is negative, set the current sum to 0, with the hope that you might find
     * more positive elements ahead, but worst case 0 is always better than negative numbers.
     * And when you do the above, ensure that your max is greater among max and current sum.
     * This helps especially when the array has a lot of negative numbers
     *
     * */

    public static int findLargestSubArrSum(int[] nums) {
        //arr = [4,-1,2,-7,3,4]

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            if (currSum >= 0) {
                currSum += num;
                if (currSum > maxSum) {
                    maxSum = currSum;
                }

            } else {
                currSum = 0;
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;

    }

    public static int findLargestSubArrSumV2(int[] nums) {
        //arr = [4,-1,2,-7,3,4]

        int maxSum = nums[0];
        int currSum = 0;
        for (int num : nums) {
            currSum = Math.max(currSum, 0);
            currSum += num;
            maxSum = Math.max(currSum, maxSum);

        }
        return Math.max(maxSum, currSum);

    }

    public static int[] findLargestSubArrSumWindow(int[] nums) {
        //arr = [4,-1,2,-7,3,4]

        int L = 0, R = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currSum >= 0) {
                currSum += nums[i];
                if (currSum > maxSum) {
                    maxSum = currSum;
                    R = i;
                }

            } else {
                currSum = 0;
                L = R;
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return Arrays.copyOfRange(nums, L, Math.min(R + 1, nums.length));

    }
}
