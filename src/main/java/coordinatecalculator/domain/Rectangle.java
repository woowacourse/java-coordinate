package coordinatecalculator.domain;

import coordinatecalculator.visitor.Visitor;

import java.util.*;

public class Rectangle implements Figure, Shape {
    public static final int VERTEX_OF_RECTANGLE = 4;
    private static final int FIRST_VERTEX = 0;
    private static final int SECOND_VERTEX = 1;
    private static final int THIRD_VERTEX = 2;
    private static final int FOURTH_VERTEX = 3;
    private static final int SQUARE = 2;

    private final List<Coordinate> coordinates;

    public Rectangle(List<Coordinate> coordinates) {
        isValidRectangle(coordinates);
        isValidShape(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidRectangle(List<Coordinate> coordinates) {
        double vertical = Math.round(Math.pow(coordinates.get(FIRST_VERTEX).calculateDistance(coordinates.get(SECOND_VERTEX)), SQUARE));
        double horizontal = Math.round(Math.pow(coordinates.get(FIRST_VERTEX).calculateDistance(coordinates.get(THIRD_VERTEX)), SQUARE));
        double diagonal = Math.round(Math.pow(coordinates.get(SECOND_VERTEX).calculateDistance(coordinates.get(THIRD_VERTEX)), SQUARE));
        checkPythagoras(vertical, horizontal, diagonal);

        vertical = Math.round(Math.pow(coordinates.get(THIRD_VERTEX).calculateDistance(coordinates.get(FOURTH_VERTEX)), SQUARE));
        horizontal = Math.round(Math.pow(coordinates.get(SECOND_VERTEX).calculateDistance(coordinates.get(FOURTH_VERTEX)), SQUARE));
        checkPythagoras(vertical, horizontal, diagonal);
    }

    private void checkPythagoras(final double vertical, final double horizontal, final double diagonal) {
        if ((vertical + horizontal) != diagonal) {
            throw new IllegalArgumentException("직사각형이 아닙니다!!");
        }
    }

    @Override
    public double area() {
        return coordinates.get(FIRST_VERTEX).calculateDistance(coordinates.get(SECOND_VERTEX)) * coordinates.get(FIRST_VERTEX).calculateDistance(coordinates.get(THIRD_VERTEX));
    }

    @Override
    public void isValidShape(List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_RECTANGLE) {
            throw new IllegalArgumentException("위치가 같은 점(point)이 존재합니다. 네 점의 위치는 달라야 합니다.");
        }
    }

    @Override
    public String separateShapeByVisitor(Visitor visitor) {
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
