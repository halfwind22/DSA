package algorithms.arrays;

import java.util.HashSet;

public class FixedSlidingWindow {

    /*
     * Given an array , return true if there are 2 elements within a window of of size k that are equal
     * Contains duplicate
     *
     *
     * **/

    public static boolean sizeKEquality(int[] nums, int k) {
        //[1,2,3,2,3,3]
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int x = 0; x < Math.min(nums.length, k); x++) {
            if (hashSet.contains(nums[x])) {
                return true;
            }
            hashSet.add(nums[x]);
        }

        int L = 0, R = L + k;
        while (R < nums.length) {

            if (hashSet.contains(nums[R])) {
                return true;
            }
            hashSet.add(nums[R]);
            hashSet.remove(nums[L]);
            L++;
            R++;
        }
        return false;
    }
}


