package coordinate.model;

import java.util.List;

public class Triangle extends AbstractFigure {

    public Triangle(List<Point> points) {
        super(points);
        validateTriangle(points);
    }

    private void validateTriangle(List<Point> points) {
        if (points.get(0).getSlope(points.get(1)) == points.get(0).getSlope(points.get(2))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public double area() {
        double lengthA = points.get(0).howFar(points.get(1));
        double lengthB = points.get(1).howFar(points.get(2));
        double lengthC = points.get(2).howFar(points.get(0));
        double s = (lengthA + lengthB + lengthC) / 2;

        return Math.sqrt(s * (s - lengthA) * (s - lengthB) * (s - lengthC));
    }
}
