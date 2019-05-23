package coordinatecalculator.domain;

import coordinatecalculator.visitor.Visitor;

import java.util.*;

public class Rectangle implements Figure, Shape {
    private static final int VERTEX_OF_RECTANGLE = 4;

    private final List<Coordinate> coordinates;

    public Rectangle(final List<Coordinate> coordinates) {
        isValidRectangle(coordinates);
        isValidShape(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidRectangle(final List<Coordinate> coordinates) {
        double vertical = Math.round(Math.pow(coordinates.get(0).calculateDistance(coordinates.get(1)), 2));
        double horizontal = Math.round(Math.pow(coordinates.get(0).calculateDistance(coordinates.get(2)), 2));
        double diagonal = Math.round(Math.pow(coordinates.get(1).calculateDistance(coordinates.get(2)), 2));
        checkPythagoras(vertical, horizontal, diagonal);

        vertical = Math.round(Math.pow(coordinates.get(2).calculateDistance(coordinates.get(3)), 2));
        horizontal = Math.round(Math.pow(coordinates.get(1).calculateDistance(coordinates.get(3)), 2));
        checkPythagoras(vertical, horizontal, diagonal);
    }

    private void checkPythagoras(final double vertical, final double horizontal, final double diagonal) {
        if ((vertical + horizontal) != diagonal) {
            throw new IllegalArgumentException("직사각형이 아닙니다!!");
        }
    }

    @Override
    public double area() {
        return coordinates.get(0).calculateDistance(coordinates.get(1)) * coordinates.get(0).calculateDistance(coordinates.get(2));
    }

    @Override
    public void isValidShape(final List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_RECTANGLE) {
            throw new IllegalArgumentException("위치가 같은 점(point)이 존재합니다. 네 점의 위치는 달라야 합니다.");
        }
    }

    @Override
    public String separateByVisitor(final Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return coordinates;
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
