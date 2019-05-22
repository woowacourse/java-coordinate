package coordinate.domain;

import java.util.List;

public class Figure {
    private final List<Point> points;

    public Figure(final List<Point> points) {
        this.points = points;
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }
}
