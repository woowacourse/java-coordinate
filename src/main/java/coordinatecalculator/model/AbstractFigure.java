package coordinatecalculator.model;

import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    protected final Points points;

    public AbstractFigure(Points points) {
        this.points = points;
    }

    protected Point getPoint(int index) {
        return points.getPoint(index);
    }

    public double distance(int originPointIndex, int destinationPointIndex) {
        return this.getPoint(originPointIndex).calculateDistance(this.getPoint(destinationPointIndex));
    }

    @Override
    public int getPointSize() {
        return points.getPointCount();
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
