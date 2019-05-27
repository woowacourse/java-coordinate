package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure, ResultPrintable {
    private static final String RESULT_FORMAT = "삼각형 넓이는 %.1f";

    private final Points points;

    private Triangle(Points points) {
        this.points = points;
    }

    public static Triangle create(Points points) {
        return new Triangle(points);
    }

    private double getResult(List<Double> distances, double sum, double result) {
        for (Double distance : distances) {
            result *= sum - distance;
        }
        return result;
    }

    private double getDistancesSum(List<Double> distances, double sum) {
        for (Double pointDistance : distances) {
            sum += pointDistance;
        }
        return sum;
    }

    private void addDistances(List<Double> distances) {
        for (int i = 0; i < points.getSize(); i++) {
            int nextIndex = getNextIndex(i);
            distances.add(points.pointsByIndex(i).getDistance(points.pointsByIndex(nextIndex)));
        }
    }

    private int getNextIndex(int i) {
        return (i == points.getSize() - 1) ? 0 : i + 1;
    }

    @Override
    public double getArea() {
        List<Double> distances = new ArrayList<>();
        double sum = 0;
        double result = 1;

        addDistances(distances);
        sum = getDistancesSum(distances, sum) / 2;
        result = getResult(distances, sum, result);

        return Math.sqrt(sum * result);
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    public String getResultMessage() {
        return String.format(RESULT_FORMAT, getArea());
    }
}
