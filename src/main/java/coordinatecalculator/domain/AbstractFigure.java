package coordinatecalculator.domain;

import java.util.List;

public abstract class AbstractFigure implements Figure {

    private final List<Point> points;

    AbstractFigure(PointGroup pointManager) {
        this.points = pointManager.getPoints();
    }

    Point getPoint(final int index) {
        return points.get(index);
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }
}