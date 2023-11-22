package algorithms.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        //[3,30,34,5,9]
        //9534330

        String string = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> {
            return (b + a).compareTo((a + b));
        }).collect(Collectors.joining());

        if (string.startsWith("0")) {
            return "0";
        }
        return string;

    }
}
