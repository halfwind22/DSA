package datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 1};
        System.out.println(checkForDuplicates(nums));
    }

    static boolean checkForDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
