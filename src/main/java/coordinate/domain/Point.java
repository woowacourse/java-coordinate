package coordinate.domain;

import java.util.Objects;

public abstract class Point {
    private final int x, y;

    Point(int x, int y) {
        validate(x, y);
        this.x = x;
        this.y = y;
    }

    public Vector2 subtract(Point p2) {
        return Vector2.of(x - p2.x, y - p2.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point to) {
        return subtract(to).length();
    }

    abstract void validate(int x, int y);

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

