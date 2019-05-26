package coordinate.domain;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
    private static final int MAX_COORDINATE_VALUE = 24;
    private static final int MIN_COORDINATE_VALUE = 1;

    private int coordinate;

    public Coordinate(int coordinate) {
        checkCoordinateValue(coordinate);
        this.coordinate = coordinate;
    }

    private void checkCoordinateValue(int coordinateValue) {
        if (coordinateValue < MIN_COORDINATE_VALUE || coordinateValue > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("좌표가 범위를 벗어났습니다.");
        }
    }

    public int getCoordinate() {
        return coordinate;
    }

    public int getDistance(Coordinate coordinate) {
        return Math.abs(this.coordinate - coordinate.coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate x = (Coordinate) o;
        return coordinate == x.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }

    @Override
    public int compareTo(Coordinate o) {
        return coordinate - o.coordinate;
    }
}
