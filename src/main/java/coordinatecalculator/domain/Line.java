package coordinatecalculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Line {
    private final List<Coordinate> coordinates;

    public Line(final List<Coordinate> coordinates) {
        isValidLine(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidLine(final List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() == 1) {
            throw new IllegalArgumentException("선이 될 수 없어요");
        }
    }

    public double getLineLength() {
        return coordinates.get(0).calculate(coordinates.get(1));
    }
}
