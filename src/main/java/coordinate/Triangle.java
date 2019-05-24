package coordinate;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    private final List<Point> points;

    private Triangle(final List<Point> points) {
        this.points = points;
    }

    public static Triangle of(List<Point> points) {
        return new Triangle(points);
    }

    public Double getArea() {
        Line a = Line.of(Arrays.asList(points.get(0), points.get(1)));
        Line b = Line.of(Arrays.asList(points.get(1), points.get(2)));
        Line c = Line.of(Arrays.asList(points.get(2), points.get(0)));

        Double s = (a.length() + b.length() + c.length()) / Double.valueOf(2.0);

        return Math.sqrt(s * (s - a.length()) * (s - b.length()) * (s - c.length()));
    }
}
