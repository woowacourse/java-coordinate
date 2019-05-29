package coordinate.domain;

import java.util.Objects;

public class Point {
    private final Value valueX;
    private final Value valueY;

    public Point(final int x, final int y) {
        this.valueX = Value.valueOf(x);
        this.valueY = Value.valueOf(y);
    }

    public double getDistance(final Point point) {
        return Math.sqrt(distanceSquare(point));
    }

    public int distanceSquare(final Point point) {
        int absX = valueX.getAbs(point.getValueX());
        int absY = valueY.getAbs(point.getValueY());
        return absX * absX + absY * absY;
    }

    public Value getValueX() {
        return valueX;
    }

    public Value getValueY() {
        return valueY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(valueX, point.valueX) &&
                Objects.equals(valueY, point.valueY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueX, valueY);
    }
}
