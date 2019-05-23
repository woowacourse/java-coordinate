package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points;

    public Points(final List<Point> points) {
        this.points = points;
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
