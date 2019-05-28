package coordinate.domain;

public class Point {
    private final Coordinate x;
    private final Coordinate y;

    public Point(final Coordinate x, final Coordinate y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(final Point point) {
        return Math.sqrt(Math.pow((x.getMinus(point.x)), 2) + Math.pow((y.getMinus(point.y)), 2));
    }

    public int distanceSquare(final Point point) {
        int absX = x.getMinus(point.x);
        int absY = y.getMinus(point.y);
        return absX * absX + absY * absY;
    }

    public int getX() {
        return x.getCoordinate();
    }

    public int getY() {
        return y.getCoordinate();
    }
}
