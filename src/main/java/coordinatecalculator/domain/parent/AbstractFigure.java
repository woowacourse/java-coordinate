package coordinatecalculator.domain.parent;

import coordinatecalculator.domain.Points;

import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    protected final Points points;

    public AbstractFigure(final Points points) {
        this.points = points;
    }

    @Override
    public Points getPoints() {
        return this.points;
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
