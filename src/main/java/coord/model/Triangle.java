package coord.model;

import java.util.Arrays;

public class Triangle extends Figure {
    private static final String NAME = "삼각형";

    protected Triangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);
        Line A = new Line(new Points(Arrays.asList(a, b)));
        Line B = new Line(new Points(Arrays.asList(b, c)));
        Line C = new Line(new Points(Arrays.asList(c, a)));
        double s = (A.length() + B.length() + C.length()) / 2.0;
        return Math.sqrt(s * (s - A.length()) * (s - B.length()) * (s - C.length()));
     }

    @Override
    public String getName() {
        return NAME;
    }
}