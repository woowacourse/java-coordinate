package coordinate.domain;

import java.util.*;

public class Rectangle extends Shape implements Figure {
    public static final int EVEN = 2;

    public Rectangle(final List<Point> points) {
        super(points);
        validate();
    }

    private void validate() {
        List<Integer> sides = getSideSquares();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer side : sides) {
            map.put(side, map.getOrDefault(side, 0) + 1);
        }
        for (Integer value : map.values()) {
            isEven(value);
        }
    }

    private void isEven(Integer value) {
        if (value % EVEN != 0) {
            throw new IllegalArgumentException("직 사각형이 아닙니다.");
        }
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

    @Override
    public String toString() {
        return "사각형 넓이는 " + area();
    }
}
