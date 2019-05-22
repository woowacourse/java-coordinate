package coordinatecalculator.domain;

import java.util.*;

public class Rectangle implements Figure, Shape {
    private final List<Coordinate> coordinates;
    public static final int VERTEX_OF_RECTANGLE = 4;

    public Rectangle(List<Coordinate> coordinates) {
        Collections.sort(coordinates);
        isValidRectangle(coordinates);
        isValidShape(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidRectangle(List<Coordinate> coordinates) {
        int vertical = (int) Math.pow(coordinates.get(0).calculate(coordinates.get(1)), 2);
        int horizontal = (int) Math.pow(coordinates.get(0).calculate(coordinates.get(2)), 2);
        int diagonal = (int) Math.pow(coordinates.get(1).calculate(coordinates.get(2)), 2);
        checkPythagoras(vertical, horizontal, diagonal);

        vertical = (int) Math.pow(coordinates.get(2).calculate(coordinates.get(3)), 2);
        horizontal = (int) Math.pow(coordinates.get(1).calculate(coordinates.get(3)), 2);
        checkPythagoras(vertical, horizontal, diagonal);
    }

    private void checkPythagoras(final int vertical, final int horizontal, final int diagonal) {
        if ((vertical + horizontal) != diagonal) {
            throw new IllegalArgumentException("직사각형이 아닙니다!!");
        }
    }

    @Override
    public double area() {
        return coordinates.get(0).calculate(coordinates.get(1)) * coordinates.get(0).calculate(coordinates.get(2));
    }

    @Override
    public double getScore() {
        return area();
    }

    @Override
    public void isValidShape(List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_RECTANGLE) {
            throw new IllegalArgumentException("사각형이 될 수 없어요");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rectangle rectangle = (Rectangle) o;
        return Objects.equals(coordinates, rectangle.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
