package coordinatecalculator.domain;

import com.google.common.base.Preconditions;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
    private static final int MAX_BOUND = 24;
    private static final int MIN_BOUND = 1;

    private final int x;
    private final int y;

    public Coordinate(final int x, final int y) {
        Preconditions.checkArgument(x >= MIN_BOUND && x <= MAX_BOUND, "범위를 초과하였습니다", x);
        Preconditions.checkArgument(y >= MIN_BOUND && y <= MAX_BOUND, "범위를 초과하였습니다", y);
        this.x = x;
        this.y = y;
    }

    public double calculateDistance(final Coordinate coordinate) {
        return Math.sqrt(Math.pow(Math.abs(coordinate.x - this.x), 2) + Math.pow(Math.abs(coordinate.y - this.y), 2));
    }

    public double calculateSlope(final Coordinate coordinate) {
        int dx = Math.abs(coordinate.x - this.x);
        int dy = Math.abs(coordinate.y - this.y);

        if (dx == 0) {
            return Double.MAX_VALUE;
        }
        return dy / dx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(final Coordinate o) {
        return (this.x == o.x) ? Integer.compare(this.y, o.y) : Integer.compare(this.x, o.x);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
