package coordinatecalculator.domain;

import coordinatecalculator.visitor.ViewVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Line implements Shape {
    public static final int VERTEX_OF_LINE = 2;

    private final List<Coordinate> coordinates;

    public Line(final List<Coordinate> coordinates) {
        isValidShape(coordinates);
        this.coordinates = coordinates;
    }

    public double getLineLength() {
        return coordinates.get(0).calculateDistance(coordinates.get(1));
    }

    @Override
    public String separateByVisitor(final ViewVisitor viewVisitor) {
        return viewVisitor.visit(this);
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return coordinates;
    }

    @Override
    public void isValidShape(final List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_LINE) {
            throw new IllegalArgumentException("위치가 같은 점(point)이 존재합니다. 두 점의 위치는 달라야 합니다.");
        }
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
