package coordinatecalculator.util;

public class OutputView {
    private static final String OUTPUT_DISTANCE="두 점 사이 거리는 ";
    public static void printDistanceBetweenTwoPoints(double distance) {
        System.out.println(OUTPUT_DISTANCE+distance);
    }
}
