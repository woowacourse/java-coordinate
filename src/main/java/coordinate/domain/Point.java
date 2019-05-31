package coordinate.domain;

import java.util.List;
import java.util.Objects;

public class Point {
    private static final int NUM_OF_COORDINATES = 2;
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 24;

    private final int x;
    private final int y;

    public Point(List<Integer> coordinates) {
        validateSizeOf(coordinates);
        validateNumberRange(coordinates.get(X_INDEX), coordinates.get(Y_INDEX));
        this.x = coordinates.get(X_INDEX);
        this.y = coordinates.get(Y_INDEX);
    }


    private void validateSizeOf(List<Integer> coordinates) {
        if (coordinates.size() != NUM_OF_COORDINATES) {
            throw new IllegalArgumentException("좌표점을 두개 입력해야 합니다");
        }
    }

    private void validateNumberRange(int x, int y) {
        validateMaxRange(x, y);
        validateMinRange(x, y);
    }

    int getDeltaXTo(Point point) {
        return point.getXDifference(x);
    }

    int getDeltaYTo(Point point) {
        return point.getYDifference(y);
    }

    public int getXDifference(int xCoordinate) {
        return Math.abs(x - xCoordinate);
    }

    public int getYDifference(int yCoordinate) {
        return Math.abs(y - yCoordinate);
    }

    boolean matchX(Point point) {
        return point.matchX(x);
    }

    private boolean matchX(int xCoordinate) {
        return xCoordinate == x;
    }

    boolean matchY(Point point) {
        return point.matchY(y);
    }

    private boolean matchY(int yCoordinate) {
        return yCoordinate == y;
    }

    private void validateMaxRange(int x, int y) {
        if (x > MAX_VALUE || y > MAX_VALUE) {
            throw new IllegalArgumentException("좌표 값은 " + MAX_VALUE + "보다 작거나 같아야 합니다 ");
        }
    }

    private void validateMinRange(int x, int y) {
        if (x < MIN_VALUE || y < MIN_VALUE) {
            throw new IllegalArgumentException("좌표 값은 " + MIN_VALUE + "보다 크거나 같아야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}