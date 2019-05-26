package coordinate.domain;

import java.util.Objects;

public class Vector2 {
    private final int x, y;

    Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2 of(int x, int y) {
        return new Vector2(x, y);
    }

    public int doProduct(Vector2 b) {
        return (this.x * b.x) + (this.y * b.y);
    }

    public double length() {
        return Math.sqrt(doProduct(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return x == vector2.x &&
                y == vector2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
