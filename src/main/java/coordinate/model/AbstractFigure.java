package coordinate.model;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    protected final List<Point> points;

    AbstractFigure(List<Point> points) {
        if (points.size() != size()) {
            throw new IllegalArgumentException();
        }

        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
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
