package coordinatecalculator.domain;

import java.util.Collections;
import java.util.List;

public abstract class AbstractFigure implements Figure {

    private final List<Point> points;

    public AbstractFigure(final List<Point> points) {
        this.points = points;
        Collections.sort(points);
    }

    public Point getPoint(final int index) {
        return points.get(index);
    }
}