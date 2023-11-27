package algorithms.arrays;

import java.util.List;
import java.util.Stack;

public class RemoveKDigits {

    //Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
    //
    //
    //
    //Example 1:
    //
    //Input: num = "1432219", k = 3
    //Output: "1219"
    //Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

    static int smallestOfSizeK(String s, int k) {
        // Get a s.length-k number(1432)
        // Fo r next digit 2,

        int minSoFar = Integer.MAX_VALUE;
        char[] charArray = s.toCharArray();
        int baseLength = s.length() - k;
        for (int i = 0; i < (s.length() - k); i++) {
            char[] newCharArray = new char[baseLength];
            newCharArray[0] = charArray[i];
            int index = 1;
            for (int j = (i + 1); j < (s.length() - k) + 1; j++) {
                //TODO : ITERATE (s.length()-k) times
            }
            minSoFar = Math.min(Integer.parseInt(String.valueOf(newCharArray)), minSoFar);
        }
        return minSoFar == Integer.MAX_VALUE ? 0 : minSoFar;
    }

    static String smallestOfSizeKV2(String num, int k) {
        int maxSize = num.length() - k;
        if (num.length() == k) return "0";
        Stack<Character> characterStack = new Stack<>();
        char[] charArray = num.toCharArray();
        for (char value : charArray) {
            while (!characterStack.isEmpty() && characterStack.peek() > value && k > 0) {
                characterStack.pop();
                k--;
            }
            characterStack.push(value);
        }

        List<Character> characters = characterStack.subList(0, maxSize);

        String result = characters.stream().map(Object::toString).reduce((a, b) -> a + b).orElseGet(() -> "");
        for (
                int i = 0; i < result.length(); i++) {
            if (!(result.charAt(i) == '0')) {
                return result.replaceAll("^0+", "");
            }
        }
        return "0";


    }

    public static void main(String[] args) {
        System.out.println(smallestOfSizeKV2("99999999999991", 8));
    }

}
