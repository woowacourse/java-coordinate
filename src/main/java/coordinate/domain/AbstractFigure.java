package coordinate.domain;


import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    static final int FIRST_POINT = 0;
    static final int SECOND_POINT = 1;
    static final int THIRD_POINT = 2;
    final Points points;

    AbstractFigure(Points points) {
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
