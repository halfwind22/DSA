package datastructures.recursion;

public class Fibonacci {

    public static int calulateFibonacci(int limit) {

        if (limit == 0) {
            return 0;
        } else if (limit == 1) {
            return 1;
        } else {
            return calulateFibonacci(limit - 1) + calulateFibonacci(limit - 2);
        }
    }
}

