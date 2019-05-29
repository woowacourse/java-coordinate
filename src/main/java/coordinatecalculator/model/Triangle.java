package coordinatecalculator.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Triangle extends Figure {
    private static final int TRIANGLE_SIZE = 3;
    private static final int START = 0;
    private static final int NEXT = 1;
    private static final int FIRST_DISTANCE = 0;
    private static final int SECOND_DISTANCE = 1;
    private static final int THIRD_DISTANCE = 2;
    private static final int HERON_NUMBER = 4;

    private double area;

    public Triangle(final Points points) {
        super(points);
        validateTrianglePoints();
        this.area = calculateResult();
    }

    private void validateTrianglePoints() {
        Set<Double> checkSlops = new HashSet<>();
        for (int i = START; i < TRIANGLE_SIZE; i++) {
            Point checkPoint = points.getPoint(i);
            Point checkNextPoint = points.getPoint((i + NEXT) % TRIANGLE_SIZE);
            checkSlops.add(checkPoint.getSlope(checkNextPoint));
        }
        if (checkSlops.size() != TRIANGLE_SIZE) {
            throw new IllegalArgumentException("잘못된 삼각형 입니다.");
        }

    }

    private double getTriangleArea(double firstLine, double secondLine, double thirdLine) {
        final double pythagorean = firstLine * firstLine + secondLine * secondLine - thirdLine * thirdLine;
        return Math.sqrt(HERON_NUMBER * firstLine * firstLine * secondLine * secondLine - pythagorean * pythagorean) / HERON_NUMBER;
    }

    @Override
    public double getResult() {
        return area;
    }

    @Override
    public double calculateResult() {
        double firstLine = points.getGenerateDistance(FIRST_DISTANCE);
        double secondLine = points.getGenerateDistance(SECOND_DISTANCE);
        double thirdLine = points.getGenerateDistance(THIRD_DISTANCE);

        return getTriangleArea(firstLine, secondLine, thirdLine);
    }

    @Override
    public String toString() {
        return "삼각형 넓이는 " + String.format("%.3f", getResult());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area);
    }
}
