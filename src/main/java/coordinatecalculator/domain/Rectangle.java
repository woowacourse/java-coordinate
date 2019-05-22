package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.List;
import java.util.Objects;

public class Rectangle implements Figure {
    private final Points points;

    public Rectangle(Points points) {
        //TODO: 기울기 -1인지 체크
        this.points = points;
    }

    @Override
    public double calculateResult() {
        List<Point> points = this.points.getSortedPoints();

        return Math.abs((points.get(0).getX() - points.get(1).getX()) * (points.get(2).getY() - points.get(0).getY()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
