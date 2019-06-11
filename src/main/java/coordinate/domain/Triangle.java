package coordinate.domain;

import java.util.*;

public class Triangle extends Figure implements Polygon {
    private static final int NUM_OF_POINT = 3;
    private static final int UNIQUE_SIZE = 1;

    Triangle(List<Point> points) {
        super(points, NUM_OF_POINT);
        validateTriangle(points);
    }

    private void validateTriangle(List<Point> points) {
        Set<Double> slopes = calculateSlopes(points);

        if (slopes.size() == UNIQUE_SIZE) {
            throw new IllegalArgumentException("한 직선에 세 개의 점이 있을 수 없습니다.");
        }
    }

    private Set<Double> calculateSlopes(List<Point> points) {
        Set<Double> slopes = new HashSet<>();

        Stack<Point> pointsStack = new Stack<>();
        pointsStack.addAll(points);
        pointsStack.addAll(points);
        while (!pointsStack.empty()) {
            slopes.add(pointsStack.pop().calculateSlope(pointsStack.pop()));
        }

        return slopes;
    }

    @Override
    public double calculateAttribute() {
        return calculateArea();
    }

    public double calculateArea() {
        List<Double> lengths = calculateLengthOfSideLines();
        Iterator<Double> lengthIterator = lengths.iterator();
        return applyHeronFormula(lengthIterator.next(), lengthIterator.next(), lengthIterator.next());
    }

    private List<Double> calculateLengthOfSideLines() {
        List<Double> lengths = new ArrayList<>();
        lengths.add(calculateLength(0, 1));
        lengths.add(calculateLength(1, 2));
        lengths.add(calculateLength(2, 0));
        return lengths;
    }

    private double applyHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}