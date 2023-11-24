package algorithms.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class SlidingWindowVariable {
    /*
     * Length of longest subarray having duplicate elements
     *
     * */

    public static int findLongestDuplicateSubArr(int[] nums) {
        // [4,2,2,3,3,3]
        int L = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int R = 1; R < nums.length; R++) {
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
        //https://leetcode.com/problems/minimum-size-subarray-sum
        int sum = 0, L = 0;
        int minL = 0, minR = 0;
        // [2,3,1,2,4,3]
        // All values positive
        //Check if sum is > than or equal to target, if yes, save the shortest length seen so far
        //Now start moving towards the left, thereby shrinking the window, this is to check if the target sum was met
        //by some recent addition from the right.
        int minLengthSubArray = Integer.MAX_VALUE;
        for (int R = 0; R < nums.length; R++) {
            sum += nums[R];
            if (sum >= target) {
                minLengthSubArray = Math.min((R - L), minLengthSubArray);
                minL = Math.max(L, minL);
                minR = Math.max(R, minR);
                while (L < R && sum >= target) {
                    sum -= nums[L];
                    L++;
                    if (sum >= target) {
                        minLengthSubArray = Math.min((R - L), minLengthSubArray);
                        minL = Math.max(L, minL);
                    }
                    System.out.println("Rvalue: " + R);
                    System.out.println("minLengthSubArray: " + minLengthSubArray);
                }
            }
        }

        System.out.println("minL: " + minL);
        System.out.println("minR: " + minR);

        return minLengthSubArray == Integer.MAX_VALUE ? 0 : minLengthSubArray + 1;
    }

    public int lengthOfLongestSubstring(String s) {
        // https://leetcode.com/problems/longest-substring-without-repeating-characters/
        // "abcabcbb"
        // 3
        //"pwwkew"
        //"wke"
        //Keep adding unique elements until a duplicate is found
        //Once a duplicate is found, and that duplicate is greater than L(this is imp becuase I am not deleting all elements before L)
        // calculate max
        // Get the next element from the first index of duplicate element >= L
        // remove the latest occurence of the duplicate element
        //Since sets have no indices, this sequential deletion is enabled for me by incrementing the L pointer.

        int L = 0;
        int longestSubstringSize = Integer.MIN_VALUE;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int R = 0; R < s.length(); R++) {
            if (hashMap.containsKey(s.charAt(R)) && (hashMap.get(s.charAt(R)) >= L)) {
                int previousIndex = hashMap.get(s.charAt(R));
                longestSubstringSize = Math.max(longestSubstringSize, (R - L));
                L = previousIndex + 1;
                hashMap.remove(s.charAt(R));
            }
            hashMap.put(s.charAt(R), R);
        }
        longestSubstringSize = Math.max(longestSubstringSize, (s.length() - L));
        return longestSubstringSize;
    }

    public int lengthOfLongestSubstringV2(String s) {
        // https://leetcode.com/problems/longest-substring-without-repeating-characters/
        // "abcabcbb"
        // 3
        //"pwwkew"
        //"wke"
        // Keep adding unique elements until a duplicate is found
        //Once a duplicate is found, my best bet is to remove all elements until the duplicate element is removed
        //Since sets have no indices, this sequential deletion is enabled for me by incrementing the L pointer.


        int L = 0;
        int longestSubstringSize = Integer.MIN_VALUE;

        HashSet<Character> hashSet = new HashSet<>();
        for (int R = 0; R < s.length(); R++) {
            if (hashSet.contains(s.charAt(R))) {
                while (hashSet.contains(s.charAt(R))) {
                    hashSet.remove(s.charAt(L));
                    L++;
                }
            }
            hashSet.add(s.charAt(R));
            longestSubstringSize = Math.max(longestSubstringSize, (R - L) + 1);

        }

        return longestSubstringSize == Integer.MIN_VALUE ? 0 : longestSubstringSize;
    }
}
