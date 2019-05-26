package coordinate.domain;

import java.util.List;

public class Points {
    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    public static Points from(List<Point> points) {
        return new Points(points);
    }


    public Point get(int i) {
        return points.get(i);
    }
}
