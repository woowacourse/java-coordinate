package coordinatecalculator.domain;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
    private static final int MAX_BOUND = 24;
    private static final int MIN_BOUND = 1;
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        if (x > MAX_BOUND || x < MIN_BOUND || y > MAX_BOUND || y < MIN_BOUND) {
            throw new IllegalArgumentException(" 범위 넘었어요 ");
        }
        this.x = x;
        this.y = y;
    }

    public double calculateDistance(Coordinate coordinate) {
        return Math.sqrt(Math.pow(Math.abs(coordinate.x - this.x), 2) + Math.pow(Math.abs(coordinate.y - this.y), 2));
    }

    public double calculateSlope(Coordinate coordinate) {
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
        if (this.x == o.x) {
            return Integer.compare(this.y, o.y);
        }
        return Integer.compare(this.x, o.x);
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
