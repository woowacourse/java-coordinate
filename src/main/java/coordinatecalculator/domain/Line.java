package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class Line implements Figure {
    private final Points points;

    public Line(final Points points) {
        this.points = points;
    }

    @Override
    public double calculateResult() {
        List<Point> points = this.points.getPoints();
        Point p1 = points.get(0);
        Point p2 = points.get(1);

        int x = Math.abs(p2.getX() - p1.getX());
        int y = Math.abs(p2.getY() - p1.getY());

        return Math.sqrt(x * x + y * y);
    }
}
