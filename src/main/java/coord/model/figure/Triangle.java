package coord.model.figure;

import coord.model.Line;
import coord.model.Point;
import coord.model.Points;

public class Triangle extends ConvexPolygon {
    protected Triangle(Points points) {
        super(points);
    }

    protected Triangle(Point... points) {
        super(new Points(points));
    }

    @Override
    public double area() {
        if (Double.compare(areaCache, .0) == 0) {
            final double a = new Line(points.get(0), points.get(1)).length();
            final double b = new Line(points.get(1), points.get(2)).length();
            final double c = new Line(points.get(2), points.get(0)).length();
            final double s = (a + b + c) / 2.0;
            areaCache = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        return areaCache;
    }
}