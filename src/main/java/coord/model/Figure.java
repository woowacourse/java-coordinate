package coord.model;

import coord.view.ConsoleMessages;

public abstract class Figure implements Areable {
    private static final int TRIANGLE = 3;
    protected final Points points;

    protected Figure(Points points) {
        this.points = points;
    }

    protected double areaOfTriangle(Point X, Point Y, Point Z) {
        double A = Distance.length(X, Y);
        double B = Distance.length(Y, Z);
        double C = Distance.length(Z, X);

        double s = (A + B + C) / 2.0;
        return Math.sqrt(s * (s - A) * (s - B) * (s - C));
    }

    protected double areaOfTriangle(Points points) {
        if (points.size() != TRIANGLE) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_FIGURE.message());
        }
        return areaOfTriangle(points.get(0), points.get(1), points.get(2));
    }

    public abstract double area();
}