package coordinate.domain;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public double length() {
        Vector2 v = points.get(0).subtract(points.get(1));

        return Math.sqrt(v.doProduct(v));
    }
}
