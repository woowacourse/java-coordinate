package coordinate.domain;

import java.util.Arrays;
import java.util.List;

public class Line extends AbstractFigure {
    private static final String name = "직선";

    public Line(List<Point> points) {
        super(points);
    }

    public Line(Point A, Point B) {
        super(Arrays.asList(A, B));
    }

    public double length() {
        Point A = point(0);
        Point B = point(1);

        return Math.sqrt(Math.pow(A.x() - B.x(), 2) + Math.pow(A.y() - B.y(), 2));
    }

    @Override
    protected String name() {
        return name;
    }

    @Override
    public double area() {
        return length();
    }

    @Override
    void valid() {

    }

    @Override
    public String toString() {
        return name() + "의 길이는 " + area() + "입니다.";
    }
}
