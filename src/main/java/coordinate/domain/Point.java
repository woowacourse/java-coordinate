package coordinate.domain;

public interface Point {
    Vector2 subtract(Point p2);

    CoordinateNumber getX();

    CoordinateNumber getY();

    boolean hasEqualX(Point p);

    boolean hasEqualY(Point p);

    double distance(Point to);
}
