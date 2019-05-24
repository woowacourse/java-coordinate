package coordinate.model;

import java.util.List;
import java.util.Objects;

public class Line extends AbstractFigure{

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double distance(int originPoint, int destinationPoint) {
        return points.get(originPoint).calculate(points.get(destinationPoint));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }


    @Override
    public List<Point> getPoints() {
        return null;
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public double area() {
        return 1;
    }
}
