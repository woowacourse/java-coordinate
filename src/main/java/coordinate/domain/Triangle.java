package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure, ResultPrintable {
    private static final String RESULT_FORMAT = "삼각형 넓이는 %.1f";
    private static final int DIVISION_STANDARD = 2;
    private static final int ONE_INDEX = 1;
    private static final int MOVE_NONE = 0;

    private final Points points;

    private Triangle(Points points) {
        this.points = points;
    }

    public static Triangle create(Points points) {
        return new Triangle(points);
    }

    private double getResult(List<Double> distances, double sum, double result) {

        return distances.stream()
                .reduce(result, (total, a) -> total * (sum - a));
    }

    private double getDistancesSum(List<Double> distances) {
        return distances.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private void addDistances(List<Double> distances) {
        for (int i = 0; i < points.getSize(); i++) {
            int nextIndex = getNextIndex(i);
            distances.add(points.getPoints(i).getDistance(points.getPoints(nextIndex)));
        }
    }

    private int getNextIndex(int i) {
        return (i == points.getSize() - ONE_INDEX) ? MOVE_NONE : i + ONE_INDEX;
    }

    @Override
    public double getArea() {
        List<Double> distances = new ArrayList<>();
        double subtractionLine = ONE_INDEX;
        double divisionLineSum;

        addDistances(distances);
        divisionLineSum = getDistancesSum(distances) / DIVISION_STANDARD;
        subtractionLine = getResult(distances, divisionLineSum, subtractionLine);

        return Math.sqrt(divisionLineSum * subtractionLine);
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
