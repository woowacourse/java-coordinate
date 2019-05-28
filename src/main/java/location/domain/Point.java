package location.domain;

import java.util.Objects;

public class Point {
    private static final String NOT_POSITIVE_MSG = "음수는 가능하지 않습니다.";
    private static final String OVER_24_MSG = "24를 넘습니다.";
    private static final int MAX_NUMBER = 24;
    private static final int MIN_NUMBER = 0;
    private final int xCoordinate;
    private final int yCoordinate;

    public Point(final int xCoordinate, final int yCoordinate) {
        isValid(xCoordinate, yCoordinate);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    private void isValid(final int xCoordinate, final int yCoordinate) {
        isOver24(xCoordinate, yCoordinate);
        isPositive(xCoordinate, yCoordinate);
    }

    private void isPositive(final int xCoordinate, final int yCoordinate) {
        if (xCoordinate < MIN_NUMBER || yCoordinate < MIN_NUMBER) {
            throw new IllegalArgumentException(NOT_POSITIVE_MSG);
        }
    }

    private void isOver24(final int xCoordinate, final int yCoordinate) {
        if (xCoordinate > MAX_NUMBER || yCoordinate > MAX_NUMBER) {
            throw new IllegalArgumentException(OVER_24_MSG);
        }
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return xCoordinate == point.xCoordinate &&
                yCoordinate == point.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
