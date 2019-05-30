package coordinate.domain;

import java.util.List;

public class Triangle extends AbstractFigure {
    private static final String name = "삼각형";

    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        double a = new Line(point(0), point(1)).length();
        double b = new Line(point(1), point(2)).length();
        double c = new Line(point(2), point(0)).length();
        double s = (a + b + c) / 2.0;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    protected String name() {
        return name;
    }
}
