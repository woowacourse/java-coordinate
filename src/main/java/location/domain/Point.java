package location.domain;

import java.util.Objects;

public class Point {
    private static final String NOT_POSITIVE_MSG = "음수는 가능하지 않습니다.";
    private static final String OVER_24_MSG = "24를 넘습니다.";
    private static final int MAX_NUMBER = 24;
    private static final int MIN_NUMBER = 0;
    private final XPoint xPoint;
    private final YPoint yPoint;

    public Point(final int xCoordinate, final int yCoordinate) {
        isValid(xCoordinate, yCoordinate);
        this.xPoint = new XPoint(xCoordinate);
        this.yPoint = new YPoint(yCoordinate);
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
        return xPoint.getValue();
    }

    public int getyCoordinate() {
        return yPoint.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return Objects.equals(xPoint, point.xPoint) &&
                Objects.equals(yPoint, point.yPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPoint, yPoint);
    }
}
