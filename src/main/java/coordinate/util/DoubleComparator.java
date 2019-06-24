package coordinate.util;

public class DoubleComparator {
    private static double threshold = 0.0001;

    public static boolean isEqual(double d1, double d2) {
        double difference = Math.abs(d1 - d2);
        return difference < threshold;
    }
}
