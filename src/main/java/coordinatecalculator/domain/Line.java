package coordinatecalculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Line {
    private static final int SAME_COORDINATES = 1;

    private final List<Coordinate> coordinates;

    public Line(final List<Coordinate> coordinates) {
        isValidLine(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidLine(final List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() == SAME_COORDINATES) {
            throw new IllegalArgumentException("선이 될 수 없어요");
        }
    }

    public double getLineLength() {
        return coordinates.get(0).calculate(coordinates.get(1));
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
