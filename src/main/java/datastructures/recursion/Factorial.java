package datastructures.recursion;

public class Factorial {

    public static int calulateFactorial(int value) {

        if (value == 1) {
            return 1;
        } else {
            return value * calulateFactorial(value - 1);
        }
    }
}
