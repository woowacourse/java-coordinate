package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class TriangleCalculator {
    double area;

    public TriangleCalculator(Figure figure) {
        validate(figure);
        this.area = calculateArea(figure);
    }

    private void validate(Figure figure) {
        if (figure.size() != 3) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
    }

    private double calculateArea(Figure figure) {
        List<Point> points = figure.getPoints();
        List<Double> sides = getSides(points);

        double halfSum = getHalfSum(sides);
        double result = halfSum;
        for (Double aDouble : sides) {
            result *= (halfSum - aDouble);
        }
        return Math.sqrt(result);
    }

    private List<Double> getSides(List<Point> points) {
        List<Double> sides = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            sides.add(points.get(i).getDistance(points.get((i + 1) % 3)));
        }
        return sides;
    }

    private double getHalfSum(List<Double> sides) {
        double result = 0;
        for (Double side : sides) {
            result += side;
        }
        return result / 2;
    }

    public double getArea() {
        return area;
    }
}
