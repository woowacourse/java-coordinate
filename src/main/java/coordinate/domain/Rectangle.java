package coordinate.domain;

import java.util.*;

import static coordinate.domain.ShapeType.RECTANGLE;

public class Rectangle extends Shape implements Figure {
    private static final int EVEN = 2;

    public Rectangle(final List<Point> points) {
        super(points);
        validateLine();
        validateShape(points.size());
    }

    private void validateShape(int size) {
        if (size != RECTANGLE.getPointSize()) {
            throw new IllegalArgumentException("사각형이 아닙니다.");
        }
    }

    private void validateLine() {
        List<Integer> sides = getSideSquares();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer side : sides) {
            map.put(side, map.getOrDefault(side, 0) + 1);
        }
        for (Integer value : map.values()) {
            validateEven(value);
        }
    }

    private void validateEven(final Integer value) {
        if (value % EVEN != 0) {
            throw new IllegalArgumentException("직 사각형이 아닙니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(area());
    }

    @Override
    public double area() {
        return calculateArea();
    }

    private double calculateArea() {
        List<Double> sides = getSides();
        Collections.sort(sides);
        return sides.get(0) * sides.get(2);
    }
}
