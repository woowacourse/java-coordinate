package coordinate.domain;

import java.util.List;

public class Rectangle extends AbstractFigure {
    private static final String name = "사각형";

    public Rectangle(List<Point> points) {
        super(points);
        valid();
    }

    @Override
    public double area() {
        Point A = point(0);
        Point B = point(1);
        Point C = point(2);

        return new Line(A, B).length() * new Line(A, C).length();
    }

    private void valid() {
        if (point(0).y() != point(1).y() || point(2).y() != point(3).y()) {
            throw new IllegalArgumentException();
        }

        if (point(0).x() != point(2).x() || point(1).x() != point(3).x()) {
            throw new IllegalArgumentException();
        }
    }

    protected String name() {
        return name;
    }
}
