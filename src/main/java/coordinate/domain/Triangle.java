package coordinate.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle extends Figure {
    private final double area;

    public Triangle(final Points points) {
        List<Double> sides = getSides(points);
        validate(sides);
        this.area = calculateArea(sides);
    }

    private List<Double> getSides(final Points figure) {
        List<Point> points = figure.getPoints();
        List<Double> sides = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            double side = points.get(i).getDistance(points.get((i + 1) % 3));
            sides.add(side);
        }
        return sides;
    }

    private void validate(final List<Double> sides) {
        if (sides.size() != 3) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
        Collections.sort(sides);
        if (sides.get(1) + sides.get(0) <= sides.get(2)) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
    }

    private double calculateArea(final List<Double> sides) {
        double halfSum = getHalfSum(sides);
        double result = halfSum;
        for (Double aDouble : sides) {
            result *= (halfSum - aDouble);
        }
        return Math.sqrt(result);
    }

    private double getHalfSum(final List<Double> sides) {
        double result = 0;
        for (Double side : sides) {
            result += side;
        }
        return result / 2;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "삼각형의 넓이는 " + area;
    }
}
