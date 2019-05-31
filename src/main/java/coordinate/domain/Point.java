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
        return point.getXDifference(x);
    }

    int getDeltaYTo(Point point) {
        return point.getYDifference(y);
    }

    private int getXDifference(XCoordinate x) {
        return x.getDifference(this.x);
    }

    public int getXDifference(int xCoordinate) {
        return x.getDifference(xCoordinate);
    }

    private int getYDifference(YCoordinate y) {
        return y.getDifference(this.y);
    }

    public int getYDifference(int yCoordinate) {
        return y.getDifference(yCoordinate);
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