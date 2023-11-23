package algorithms.arrays;

public class TwoPointers {

    public boolean checkIfPalindrome(int[] nums) {
        //Palindrome using 2 pointers
        int L = 0, R = nums.length - 1;
        while (L < R) {
            if (nums[L] != nums[R]) {
                return false;
            }
            L++;
            R--;
        }

        return true;
    }

    public int[] twoSumInputArrayIsSorted(int[] nums, int target) {
        //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
        //Given a sorted array of integers, return two distinct indices  such that the sum of elements at those indices equal target
        //[2,7,11,15] target = 9
        int L = 0, R = nums.length - 1;
        while (L < R) {
            if ((nums[L] + nums[R]) > target) {
                R--;
            } else if ((nums[L] + nums[R]) < target) {
                L++;
            } else {
                return new int[]{L + 1, R + 1};
            }
        }
        return new int[]{2};
    }
}
