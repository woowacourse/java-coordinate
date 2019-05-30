package coordinate.domain;

import java.util.List;

public abstract class AbstractFigure implements Figure {
    private List<Point> points;

    AbstractFigure(List<Point> points) {
        this.points = points;
    }

    Point point(int index) {
        return points.get(index);
    }

    @Override
    public abstract double area();

}
