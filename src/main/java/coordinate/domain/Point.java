package coordinate.domain;

import java.util.Objects;

public class Point {
    private final XCoordinate x;
    private final YCoordinate y;

    Point(int x, int y) {
        this.x = XCoordinate.of(x);
        this.y = YCoordinate.of(y);
    }

    int getDeltaXTo(Point point) {
        return x.calculateDifference(point.x);
    }

    int getDeltaYTo(Point point) {
        return y.calculateDifference(point.y);
    }

    public int getXDifference(int xCoordinate) {
        return x.calculateDifference(xCoordinate);
    }

    public int getYDifference(int yCoordinate) {
        return y.calculateDifference(yCoordinate);
    }

    boolean matchX(Point point) {
        return point.matchX(x);
    }

    private boolean matchX(Coordinate x) {
        return x.equals(this.x);
    }

    boolean matchY(Point point) {
        return point.matchY(y);
    }

    private boolean matchY(Coordinate y) {
        return y.equals(this.y);
    }

    Double calculateSlope(Point endPoint) {
        if (matchX(endPoint)) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) getDeltaYTo(endPoint) / getDeltaXTo(endPoint);
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