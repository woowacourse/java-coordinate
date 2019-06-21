package coordinatecalculator.domain;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
    private static final int SQUARE = 2;
    private static final int ZERO = 0;

    private CoordinatePoint x;
    private CoordinatePoint y;

    public Coordinate(int x, int y) {
        this.x = new CoordinatePoint(x);
        this.y = new CoordinatePoint(y);
    }

    public double calculateDistance(Coordinate coordinate) {
        return Math.sqrt(Math.pow(Math.abs(coordinate.x.getCoordinate() - this.x.getCoordinate()), SQUARE) + Math.pow(Math.abs(coordinate.y.getCoordinate() - this.y.getCoordinate()), SQUARE));
    }

    public double calculateSlope(Coordinate coordinate) {
        int dx = Math.abs(coordinate.x.getCoordinate() - this.x.getCoordinate());
        int dy = Math.abs(coordinate.y.getCoordinate() - this.y.getCoordinate());

        if (dx == ZERO) {
            return Double.POSITIVE_INFINITY; //양의 무한대값
        }
        return dy / dx;
    }

    public int getX() {
        return x.getCoordinate();
    }

    public int getY() {
        return y.getCoordinate();
    }

    @Override
    public int compareTo(final Coordinate o) {
        if (this.x.getCoordinate() == o.x.getCoordinate()) {
            return Integer.compare(this.y.getCoordinate(), o.y.getCoordinate());
        }
        return Integer.compare(this.x.getCoordinate(), o.x.getCoordinate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
