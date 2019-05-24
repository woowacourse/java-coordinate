package coord.model;

import java.util.Arrays;

public abstract class Figure {
    private static final int TRIANGLE = 3;
    private static final int QUADRANGLE = 4;
    protected final Points points;

    public static Figure fromPoints(Points points) {
        if (points.size() < TRIANGLE) {
            throw new IllegalArgumentException("점의 개수가 너무 적습니다.");
        }
        if (points.size() == TRIANGLE) {
            return new Triangle(points);
        }
        if (points.size() == QUADRANGLE) {
            return new Quadrangle(new Points(points.getPoints()));
        }
        throw new IllegalArgumentException();
    }

    protected Figure(Points points) {
        this.points = points;
    }

    protected double areaOfTriangle(Point X, Point Y, Point Z) {

        Line A = new Line(new Points(Arrays.asList(X, Y)));
        Line B = new Line(new Points(Arrays.asList(Y, Z)));
        Line C = new Line(new Points(Arrays.asList(Z, X)));

        double s = (A.length() + B.length() + C.length()) / 2.0;
        return Math.sqrt(s * (s - A.length()) * (s - B.length()) * (s - C.length()));
    }

    protected double areaOfTriangle(Points points) {
        if (points.size() != TRIANGLE) {
            throw new IllegalArgumentException();
        }
        return areaOfTriangle(points.get(0), points.get(1), points.get(2));
    }

    public abstract double area();

    public abstract String getName();
}