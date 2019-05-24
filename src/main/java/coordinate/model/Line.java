package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Point> points) {
        super(points);
    }

    public double distance() {
        return points.get(0).howFar(points.get(1));
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public double area() {
        return 0;
    }
}
