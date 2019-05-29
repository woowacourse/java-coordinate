package calculator.domain;

import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class Point implements Comparable<Point> {
    private static final String EX_COORDINATE_RANGE_MESSAGE = "좌표 범위는 0~24 사이입니다.";
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;
    private final int xCoordinate;
    private final int yCoordinate;

    /**
     * 생성자
     *
     * @param xCoordinate x좌표
     * @param yCoordinate y좌표
     */
    public Point(int xCoordinate, int yCoordinate) {
        checkXCoordinateRange(xCoordinate);
        checkYCoordinateRange(yCoordinate);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    private void checkXCoordinateRange(int xCoordinate) {
        if (xCoordinate < MIN_COORDINATE || xCoordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_COORDINATE_RANGE_MESSAGE);
        }
    }

    private void checkYCoordinateRange(int yCoordinate) {
        if (yCoordinate < MIN_COORDINATE || yCoordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_COORDINATE_RANGE_MESSAGE);
        }
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }

    public double straight(Point operand) {
        return Math.sqrt(Math.pow(this.getX() - operand.getX(), 2) + Math.pow(this.getY() - operand.getY(), 2));
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

    @Override
    public int compareTo(Point o) {
        if (this.getX() < o.getX()) {
            return 1;
        }
        if (this.getX() == o.getX() && this.getY() < o.getY() ) {
            return 1;
        }
        return -1;
    }
}
