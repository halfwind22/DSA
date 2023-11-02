package datastructures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Anagram {

    private Set<Character> characterSet;

    public Anagram() {
        this.characterSet = new HashSet<>();
    }

    public boolean checkAnagram(String s1, String s2) {

        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        if (charArr1.length == charArr2.length) {
            for (int i = 0; i < charArr2.length; i++) {
                if (charArr1[i] != charArr2[i]) {
                    return false;
                }
            }
            return true;
        }

        return false;

    }
}
