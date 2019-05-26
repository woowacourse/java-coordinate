package coordinate.domain;

import java.util.Objects;

public abstract class Figure implements Shape {
    Points points;

    Figure(Points points) {
        this.points = points;
    }

    public abstract double calculateFigure();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(points, figure.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
