package coordinate.domain;

import java.util.List;

public class Rectangle extends AbstractFigure {
    private static final String name = "사각형";

    public Rectangle(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        Point A = point(0);
        Point B = point(1);
        Point C = point(2);

        return new Line(A, B).length() * new Line(A, C).length();
    }

    protected String name() {
        return name;
    }
}
