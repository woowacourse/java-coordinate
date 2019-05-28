package coordinate.domain.point;

import java.util.Objects;

public class Point {
    private final Coordinate xCoordinate;
    private final Coordinate yCoordinate;

    public Point(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = Coordinate.get(xCoordinate);
        this.yCoordinate = Coordinate.get(yCoordinate);
    }

    public int getDistanceX(Point endPoint) {
        return xCoordinate.getDistance(endPoint.xCoordinate);
    }

    public int getDistanceY(Point endPoint) {
        return yCoordinate.getDistance(endPoint.yCoordinate);
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
