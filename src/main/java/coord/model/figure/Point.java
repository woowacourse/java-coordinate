package coord.model.figure;

import java.util.Objects;

public final class Point {
    private static final int MIN = 0;
    private static final int MAX = 24;

    final public int x;
    final public int y;

    public Point(int x, int y) {
        if (x < MIN || x > MAX || y < MIN || y > MAX) {
            throw new IllegalArgumentException("x, y의 범위는 "+ MIN + " ~ " + MAX + "입니다.");
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point rhs = (Point) o;
        return x == rhs.x && y == rhs.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}