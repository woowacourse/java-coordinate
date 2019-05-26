package coordinatecalculator.domain;

import java.util.Collections;
import java.util.List;

public abstract class AbstractFigure implements Figure {

    private final List<Point> points;

    AbstractFigure(final List<Point> points) {
        this.points = points;
        Collections.sort(points);
    }

    Point getPoint(final int index) {
        return points.get(index);
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }
}