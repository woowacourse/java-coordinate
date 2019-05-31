package coordinate.domain.point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;

    private final int coordinate;
    private static final List<Coordinate> coordinates;

    static {
        coordinates = new ArrayList<>();
        for (int i = MIN_COORDINATE; i <= MAX_COORDINATE; i++) {
            coordinates.add(new Coordinate(i));
        }
    }

    private Coordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public static Coordinate get(int index) {
        validateCoordinateRange(index);
        return coordinates.get(index);
    }

    private static void validateCoordinateRange(int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException("좌표는 0과 24 사이의 값이여야 합니다.");
        }
    }

    int getDistance(Coordinate endPointCoordinate) {
        return endPointCoordinate.coordinate - this.coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return coordinate == that.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
