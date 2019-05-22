package coordinate.domain;

import coordinate.domain.Coordinate.Coordinate;
import coordinate.domain.Coordinate.XCoordinate;
import coordinate.domain.Coordinate.YCoordinate;

import java.util.Objects;

public class Point {
    private final Coordinate xCoordinate;
    private final Coordinate yCoordinate;

    private Point(Coordinate xCoordinate, Coordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Point create(int xCoordinate, int yCoordinate) {
        return new Point(new XCoordinate(xCoordinate), new YCoordinate(yCoordinate));
    }

    public double getDistanceWith(Point coor2) {
        return Math.sqrt(Math.pow(this.xCoordinate.getDiffWith(coor2.xCoordinate), 2)
                + Math.pow(this.yCoordinate.getDiffWith(coor2.yCoordinate), 2));
    }

    public boolean func(int yValue) {
        if (getYValue() == yValue) return true;
        return false;
    }

    public int getXValue() {
        return xCoordinate.getValue();
    }

    public int getYValue() {
        return yCoordinate.getValue();
    }

    public boolean func2(int j, int i) {
        if (getYValue() == j && getXValue() == i) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return point.xCoordinate.equals(xCoordinate)
                && point.yCoordinate.equals(yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate.hashCode() + yCoordinate.hashCode());
    }
}
