package coordinate.domain;

import java.util.List;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        validateNotNull(points);
        this.points = points;
    }

    public Point getIndex(int index) {
        return points.get(index);
    }

    public int getSize() {
        return points.size();
    }
}
