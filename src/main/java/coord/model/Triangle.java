package coord.model;

import java.util.Arrays;

public class Triangle extends Figure {
    private static final String NAME = "삼각형";

    protected Triangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        Line A = new Line(new Points(Arrays.asList(points.get(0), points.get(1))));
        Line B = new Line(new Points(Arrays.asList(points.get(1), points.get(2))));
        Line C = new Line(new Points(Arrays.asList(points.get(2), points.get(1))));
        double s = (A.length() + B.length() + C.length()) / 2.0;
        return Math.sqrt(s * (s - A.length()) * (s - B.length()) * (s - C.length()));
     }

    @Override
    public String getName() {
        return NAME;
    }
}