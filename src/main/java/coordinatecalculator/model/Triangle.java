package coordinatecalculator.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Triangle implements Figure {
    private static final int TRIANGLE_SIZE = 3;
    private static final int START = 0;
    private static final int NEXT = 1;
    private static final int FIRST_DISTANCE = 0;
    private static final int SECOND_DISTANCE = 1;
    private static final int THRID_DISTANCE = 2;

    private double area;

    public Triangle(final Points points) {
        this.area = calculateResult(validateTrianglePoints(points));
    }

    private Points validateTrianglePoints(Points points) {
        Set<Double> checkSlops = new HashSet<>();
        for (int i = START; i < TRIANGLE_SIZE; i++) {
            checkSlops.add(points.getPoint(i).getSlope(points.getPoint((i + NEXT) % TRIANGLE_SIZE)));
        }
        if (checkSlops.size() != TRIANGLE_SIZE) {
            throw new IllegalArgumentException("잘못된 삼각형 입니다.");
        }
        return points;
    }

    private double getTriangleArea(double firstLine, double secondLine, double thirdLine) {
        final double pythagorean = firstLine * firstLine + secondLine * secondLine - thirdLine * thirdLine;
        return Math.sqrt(4 * firstLine * firstLine * secondLine * secondLine - pythagorean * pythagorean) / 4;
    }

    @Override
    public double getResult() {
        return area;
    }

    @Override
    public double calculateResult(final Points points) {
        double firstLine = points.generateDistances().get(FIRST_DISTANCE).getDistance();
        double secondLine = points.generateDistances().get(SECOND_DISTANCE).getDistance();
        double thirdLine = points.generateDistances().get(THRID_DISTANCE).getDistance();

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
