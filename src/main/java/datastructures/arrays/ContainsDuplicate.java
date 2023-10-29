package datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 1};
        System.out.println(checkForDuplicates(nums));
    }

    static boolean checkForDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (!set.contains(j)) {
                set.add(j);
            } else {
                return true;
            }
        }
        return false;
    }
}
