package coordinate.util;

public class DoubleCompare {
    public static boolean deltaCompare(double num1, double num2, double delta) {
        return Math.abs(num1 - num2) < delta;
    }
}
