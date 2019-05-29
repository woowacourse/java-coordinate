package calculator.domain;

import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class Point implements Comparable<Point> {
    private final Coordinate xCoordinate;
    private final Coordinate yCoordinate;

    /**
     * 생성자
     *
     * @param xCoordinate x좌표
     * @param yCoordinate y좌표
     */
    public Point(Coordinate xCoordinate, Coordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getX() {
        return xCoordinate.value();
    }

    public int getY() {
        return yCoordinate.value();
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
