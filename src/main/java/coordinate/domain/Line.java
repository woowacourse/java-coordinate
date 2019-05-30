package coordinate.domain;

import java.util.Arrays;
import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Point> points) {
        super(points);
    }

    public Line(Point A, Point B) {
        super(Arrays.asList(A, B));
    }

    public double length() {
        Point A = point(0);
        Point B = point(1);

        return Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2));
    }

    @Override
    public double area() {
        throw new IllegalArgumentException();
    }
}
