package coordinatecalculator;

import java.util.Arrays;
import java.util.List;

class Triangle extends Polygon {
    Triangle(List<Point> points) {
        super(points);
        lines = makeSegment(this.points);
    }

    public static Triangle of(Point p1, Point p2, Point p3) {
        return new Triangle(Arrays.asList(p1, p2, p3));
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public int getPointsCount() {
        return 3;
    }

    @Override
    public double area() {
        double a = lines.get(0).getLength();
        double b = lines.get(1).getLength();
        double c = lines.get(2).getLength();
        return heronFormula(a, b, c);
    }
}
