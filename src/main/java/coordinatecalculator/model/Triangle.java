package coordinatecalculator.model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Triangle extends Polygon {
    private static final DecimalFormat FORMAT = new DecimalFormat("0.###");

    public Triangle(List<Point> points) {
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

    private static double heronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
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

    @Override
    public String toString() {
        return "삼각형의 넓이는 "
                + FORMAT.format(area())
                + "입니다.";
    }
}
