package algorithms.dynamicprogramming;

import java.util.HashMap;

public class OneDimensionalDP {

    public int calculateFibonacci(int n, HashMap<Integer, Integer> cache) {
        // Very efficient implementation of Fibonacci using memoization in O(n)
        if (n < 2) {
            return n;
        }
        cache.put(n, calculateFibonacci(n - 1, cache) + calculateFibonacci(n - 2, cache));
        return cache.get(n);

    }

    public int calculateFibonacciV2(int n) {
        // Very efficient implementation of Fibonacci using memoization
        int[] resultArr = new int[]{0, 1};

        if (n < 2) {
            return resultArr[n];
        }
        int i = 2;
        while (i <= n) {
            int temp = resultArr[1] + resultArr[0];
            resultArr[0] = resultArr[1];
            resultArr[1] = temp;
            i++;
        }


        return resultArr[1];
    }
}
