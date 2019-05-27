package coordinatecalculator.model.coordinate;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
    private static final int MIN_COORDINATE_VALUE = 0;
    private static final int MAX_COORDINATE_VALUE = 24;

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        checkCoordinateRange(x);
        checkCoordinateRange(y);

        this.x = x;
        this.y = y;
    }

    private void checkCoordinateRange(int coordinateValue) {
        if ((coordinateValue < MIN_COORDINATE_VALUE) || (coordinateValue > MAX_COORDINATE_VALUE)) {
            throw new IllegalArgumentException(MIN_COORDINATE_VALUE + "에서 " + MAX_COORDINATE_VALUE + "사이 값을 입력해주세요.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Coordinate o) {
        if (this.x < o.x || this.x == o.x && this.y < o.y) {
            return -1;
        }
        return 1;
    }
}
