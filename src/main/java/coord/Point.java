package coord;

import java.util.Objects;

public class Point {
    private static final int MIN = 0;
    private static final int MAX = 24;

    final public int x;
    final public int y;

    public Point(int x, int y) {
        if (x < MIN || x > MAX || y < MIN || y > MAX) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}