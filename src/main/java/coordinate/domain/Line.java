package coordinate.domain;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public double length() {
        Point a = points.get(0);
        Point b = points.get(1);
        return a.length(b);
    }
}
