package calculator.domain;

import java.util.Objects;
import java.util.Set;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class Point {
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

    public Point(int xCoordinate, int yCoordinate) {
        this(new Coordinate(xCoordinate), new Coordinate(yCoordinate));
    }

    public Set<Coordinate> duplicateXCoordinates(Set<Coordinate> coordinates) {
        coordinates.add(this.xCoordinate);
        return coordinates;
    }

    public Set<Coordinate> duplicateYCoordinates(Set<Coordinate> coordinates) {
        coordinates.add(this.yCoordinate);
        return coordinates;
    }

    public int getXCoordinateValue() {
        return xCoordinate.value();
    }

    public int getYCoordinateValue() {
        return yCoordinate.value();
    }

    public double straight(Point operand) {
        return Math.sqrt(Math.pow(operand.differenceX(this.xCoordinate), 2) + Math.pow(operand.differenceY(this.yCoordinate), 2));
    }

    private double differenceX(Coordinate coordinate) {
        return this.xCoordinate.difference(coordinate);
    }

    private double differenceY(Coordinate coordinate) {
        return this.yCoordinate.difference(coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xCoordinate, point.xCoordinate) &&
                Objects.equals(yCoordinate, point.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
