package coordinatecalculator.domain;

import coordinatecalculator.visitor.ViewVisitor;

import java.util.*;

public class Rectangle implements Figure, Shape {
    public static final int VERTEX_OF_RECTANGLE = 4;
    private static final int FOURTH_COORDINATE = 3;
    private static final int SQUARE = 2;

    private final Coordinates coordinates;

    public Rectangle(final Coordinates coordinates) {
        isValidRectangle(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidRectangle(Coordinates coordinates) {
        double vertical = Math.round(Math.pow(coordinates.getDistanceBetweenTwoPoints(FIRST_COORDINATE, SECOND_COORDINATE), SQUARE));
        double horizontal = Math.round(Math.pow(coordinates.getDistanceBetweenTwoPoints(FIRST_COORDINATE, THIRD_COORDINATE), SQUARE));
        double diagonal = Math.round(Math.pow(coordinates.getDistanceBetweenTwoPoints(SECOND_COORDINATE, THIRD_COORDINATE), SQUARE));
        checkPythagoras(vertical, horizontal, diagonal);

        vertical = Math.round(Math.pow(coordinates.getDistanceBetweenTwoPoints(THIRD_COORDINATE, FOURTH_COORDINATE), SQUARE));
        horizontal = Math.round(Math.pow(coordinates.getDistanceBetweenTwoPoints(SECOND_COORDINATE, FOURTH_COORDINATE), SQUARE));
        checkPythagoras(vertical, horizontal, diagonal);
    }

    private void checkPythagoras(final double vertical, final double horizontal, final double diagonal) {
        if ((vertical + horizontal) != diagonal) {
            throw new IllegalArgumentException("직사각형이 아닙니다!!");
        }
    }

    @Override
    public double area() {
        return coordinates.getDistanceBetweenTwoPoints(FIRST_COORDINATE, SECOND_COORDINATE) *
                coordinates.getDistanceBetweenTwoPoints(FIRST_COORDINATE, THIRD_COORDINATE);
    }

    @Override
    public String separateByVisitor(final ViewVisitor viewVisitor) {
        return viewVisitor.visit(this);
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return coordinates.getCoordinates();
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
