package coord.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class Figure implements Areable {
    private static final int TRIANGLE = 3;
    private static final int QUADRANGLE = 4;
    private static Map<Integer, Function<Points, Figure>> figureMap;
    protected final Points points;

    protected Figure(Points points) {
        this.points = points;
    }

    public static Figure getInstance(Points points) {
        if (figureMap == null) {
            setFigureMap();
        }
        try {
            return figureMap.get(points.size()).apply(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void setFigureMap() {
        figureMap = new HashMap<>();
        figureMap.put(TRIANGLE, point -> new Triangle(point));
        figureMap.put(QUADRANGLE, point -> new Quadrangle(point));
    }

    protected double areaOfTriangle(Point X, Point Y, Point Z) {

        Line A = new Line(X, Y);
        Line B = new Line(Y, Z);
        Line C = new Line(Z, X);

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