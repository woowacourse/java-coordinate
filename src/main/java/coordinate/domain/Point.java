package coordinate.domain;

public class Point {
    private final Coordinate x;
    private final Coordinate y;

    public Point(final int x, final int y) {
        this.x = Coordinate.of(x);
        this.y = Coordinate.of(y);
    }

    public double length(final Point other) {
        double squareOfX = square(this.x.value(), other.x.value());
        double squareOfY = square(this.y.value(), other.y.value());
        return Math.sqrt(squareOfX + squareOfY);
    }

    private double square(final int first, final int second) {
        return Math.pow(first - second, 2);
    }

    public int getX() {
        return x.value();
    }

    public int getY() {
        return y.value();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}
