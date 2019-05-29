package coordinate.domain;

import java.util.Objects;

public abstract class AbstractPoint implements Point {
    private final CoordinateNumber x, y;

    AbstractPoint(CoordinateNumber x, CoordinateNumber y) {
        validate(x.toInt(), y.toInt());
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2 subtract(Point p) {
        return Vector2.of(x.subtract(p.getX()), y.subtract(p.getY()));
    }

    @Override
    public CoordinateNumber getX() {
        return x;
    }

    @Override
    public CoordinateNumber getY() {
        return y;
    }

    @Override
    public boolean hasEqualX(Point p) {
        return x.equals(p.getX());
    }

    @Override
    public boolean hasEqualY(Point p) {
        return y.equals(p.getY());
    }

    @Override
    public double distance(Point to) {
        return subtract(to).length();
    }

    abstract void validate(int x, int y);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPoint abstractPoint = (AbstractPoint) o;
        return x == abstractPoint.x &&
                y == abstractPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

