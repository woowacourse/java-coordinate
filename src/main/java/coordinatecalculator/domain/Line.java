package coordinatecalculator.domain;

import coordinatecalculator.visitor.ViewVisitor;

import java.util.List;
import java.util.Objects;

public class Line implements Shape {
    public static final int VERTEX_OF_LINE = 2;

    private final Coordinates coordinates;

    public Line(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public double getLineLength() {
        return coordinates.getDistanceBetweenTwoPoints(FIRST_COORDINATE, SECOND_COORDINATE);
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
        final Line line = (Line) o;
        return Objects.equals(coordinates, line.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
