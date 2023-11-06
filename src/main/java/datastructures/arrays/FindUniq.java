package datastructures.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindUniq {
    public int firstUniqChar(String s) {
        Map<Character, Integer> hmap = new LinkedHashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
            char ch = entry.getKey();
            int val = entry.getKey();
            if (entry.getValue() == 1) {
                for (int i = 0; i < charArr.length; i++) {
                    if (charArr[i] == ch) {
                        return i;
                    }
                }
            }
        }
        return -1;

    }

    public int firstUniqCharV1(String s) {
        /*
         * If first index and last index of a character are same, then that is yoiur first non repeating character.
         *
         * */
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (s.lastIndexOf(charArr[i]) == s.indexOf(charArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharV2(String s) {
        int ans = Integer.MAX_VALUE;
        int index = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            /*
             * O(1) Constant time play
             * */
            index = s.indexOf(ch);
            if (index != -1 && s.lastIndexOf(ch) == index) {
                ans = Math.min(ans, index);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
