package geometryandmath;

import java.util.Arrays;

public class PlusOne {

    /*
     * You are given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer. The digits are ordered
     *  from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * */

    public static int[] plusOne(int[] digits) {

        java.math.BigInteger bi = new java.math.BigInteger(Arrays.toString(digits).replaceAll("\\[|\\]|\\,|\\s", ""));
        char[] charArr = bi.add(java.math.BigInteger.valueOf(1)).toString().toCharArray();
        int[] returnArray = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            returnArray[i] = Character.getNumericValue(charArr[i]);
        }

        return returnArray;


    }

    public int[] plusOneEfficient(int[] digits) {
        int carryOver = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + carryOver;
                return digits;
            }
        }

        int[] resultArray = new int[digits.length + 1];
        resultArray[0] = 1;
        System.arraycopy(digits, 0, resultArray, 1, digits.length);
        return resultArray;


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{6, 1, 4, 5, 7, 6, 3, 2, 0, 9, 1, 2, 5, 6, 4, 9})));
    }
}
