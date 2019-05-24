package coordinate.model;

import java.util.List;
import java.util.Objects;

public class Line extends AbstractFigure{

    public Line(List<Point> points) {
        super(points);
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

    public double calculateDistance() {
        return points.get(0).calculate(points.get(1));
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
    public String getName() {
        return null;
    }

    @Override
    public double area() {
        return 0;
    }
}
