package coordinate.domain;

import java.util.Collections;
import java.util.List;

public class Triangle extends Shape implements Figure {
    public Triangle(final Points points) {
        super(points);
        validate();
    }

    private void validate() {
        List<Double> sides = getSides();
        Collections.sort(sides);
        if (sides.get(1) + sides.get(0) <= sides.get(2)) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
    }

    private double calculateArea() {
        List<Double> sides = getSides();
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
    public double area() {
        return calculateArea();
    }

    @Override
    public String toString() {
        return "삼각형의 넓이는 " + area();
    }
}
