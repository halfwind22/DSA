package algorithms.arrays;

public class SlidingWindowVariable {
    /*
     * Length of longest subarray having duplicate elements
     *
     * */

    public static int findLongestDuplicateSubArr(int[] nums) {
        // [4,2,2,3,3,3]
        int L = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int R = 0; R < nums.length; R++) {
            if (nums[R] != nums[L]) {
                maxLength = Math.max(maxLength, R - L);
                L = R;
            }
        }
        maxLength = Math.max(maxLength, nums.length - L);
        return maxLength;
    }

    public static int findMinLengthSubArr(int[] nums, int target) {
        int sum = 0, R = 0;
        // [2,3,1,2,4,3]
        // All values positive
        //check if sum is > than or equal to target, if yes, save the shortest length seen so far
        int minLengthSubArray = Integer.MAX_VALUE;
        for (int i = R; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLengthSubArray = Math.min((j - i + 1), minLengthSubArray);
                }
            }
            sum = 0;
        }

        return minLengthSubArray;
    }

    public static int findMinLengthSubArrV2(int[] nums, int target) {
        int sum = 0, L = 0;
        // [2,3,1,2,4,3]
        // All values positive
        //check if sum is > than or equal to target, if yes, save the shortest length seen so far
        int minLengthSubArray = Integer.MAX_VALUE;
        for (int R = 0; R < nums.length; R++) {
            sum += nums[R];
            if (sum >= target) {
                minLengthSubArray = Math.min((R - L), minLengthSubArray);
                sum -= nums[L];
                L++;
            }
        }

        return minLengthSubArray == Integer.MAX_VALUE ? 0 : minLengthSubArray;
    }
}
