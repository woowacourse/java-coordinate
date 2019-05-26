package coordinate.domain;


import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    final Points points;

    public AbstractFigure(Points points) {
        this.points = points;
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    public abstract String getResult();

    @Override
    public abstract double calculateArea();

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
